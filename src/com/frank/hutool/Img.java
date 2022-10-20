package com.frank.hutool;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author kst
 * @date 2020-10-10 13:59:27
 */
public class Img {

	private final BufferedImage srcImage;
	private Image targetImage;
	/**
	 * 目标图片文件格式，用于写出
	 */
	private String targetImageType;

	/**
	 * 默认除法运算精度
	 */
	private static final int DEFAUT_DIV_SCALE = 10;

	/**
	 * 图片输出质量，用于压缩
	 */
	private float quality = -1;

	// 联合照片专家组
	public static final String IMAGE_TYPE_JPG = "jpg";

	// 可移植网络图形
	public static final String IMAGE_TYPE_PNG = "png";

	/**
	 * 构造
	 *
	 * @param srcImage        来源图片
	 * @param targetImageType 目标图片类型
	 * @since 5.0.7
	 */
	public Img(BufferedImage srcImage, String targetImageType) {
		this.srcImage = srcImage;
		if (null == targetImageType) {
			targetImageType = IMAGE_TYPE_JPG;
		}
		this.targetImageType = targetImageType;
	}

	/**
	 * 从文件读取图片并开始处理
	 *
	 * @param imageFile 图片文件
	 * @return {@link Img}
	 * @throws IOException
	 */
	public static Img from(File imageFile) throws IOException {
		return new Img(read(imageFile), null);
	}

	/**
	 * 从文件中读取图片
	 *
	 * @param imageFile 图片文件
	 * @return 图片
	 * @throws IOException
	 * @since 3.2.2
	 */
	public static BufferedImage read(File imageFile) throws IOException {
		BufferedImage result;
		try {
			result = ImageIO.read(imageFile);
		} catch (IOException e) {
			throw new IOException(e);
		}
		if (null == result) {
			throw new IllegalArgumentException("Image type of file [" + imageFile.getName() + "] is not supported!");
		}
		return result;
	}

	/**
	 * 设置目标图片文件格式，用于写出
	 *
	 * @param imgType 图片格式
	 * @return this
	 */
	public Img setTargetImageType(String imgType) {
		this.targetImageType = imgType;
		return this;
	}

	/**
	 * 等比缩放图像，此方法按照按照给定的长宽等比缩放图片，按照长宽缩放比最多的一边等比缩放，空白部分填充背景色<br>
	 * 缩放后默认为jpeg格式
	 *
	 * @param width  缩放后的宽度
	 * @param height 缩放后的高度
	 * @return this
	 */
	public Img scale(int width, int height) {
		Image srcImage = getValidSrcImg();
		int srcHeight = srcImage.getHeight(null);
		int srcWidth = srcImage.getWidth(null);
		double heightRatio = div(height, srcHeight, DEFAUT_DIV_SCALE);
		double widthRatio = div(width, srcWidth, DEFAUT_DIV_SCALE);

		if (widthRatio == heightRatio) {
			// 长宽都按照相同比例缩放时，返回缩放后的图片
			imageScale(width, height);
		} else if (widthRatio < heightRatio) {
			// 宽缩放比例多就按照宽缩放
			imageScale(width, (int) (srcHeight * widthRatio));
		} else {
			// 否则按照高缩放
			imageScale((int) (srcWidth * heightRatio), height);
		}

		// 获取缩放后的新的宽和高
		srcImage = getValidSrcImg();
		srcHeight = srcImage.getHeight(null);
		srcWidth = srcImage.getWidth(null);

		final BufferedImage image = new BufferedImage(width, height, getTypeInt());
		Graphics2D g = image.createGraphics();

		// 在中间贴图
		g.drawImage(srcImage, (width - srcWidth) / 2, (height - srcHeight) / 2, srcWidth, srcHeight, null, null);
		g.dispose();
		this.targetImage = image;
		return this;
	}

	/**
	 * 缩放图像（按长宽缩放）<br>
	 * 注意：目标长宽与原图不成比例会变形
	 *
	 * @param width  目标宽度
	 * @param height 目标高度
	 * @return this
	 */
	public Img imageScale(int width, int height) {
		final Image srcImg = getValidSrcImg();

		int srcHeight = srcImg.getHeight(null);
		int srcWidth = srcImg.getWidth(null);
		int scaleType;
		if (srcHeight == height && srcWidth == width) {
			// 源与目标长宽一致返回原图
			this.targetImage = srcImg;
			return this;
		} else if (srcHeight < height || srcWidth < width) {
			// 放大图片使用平滑模式
			scaleType = Image.SCALE_SMOOTH;
		} else {
			scaleType = Image.SCALE_DEFAULT;
		}

		double sx = div(width, srcWidth, DEFAUT_DIV_SCALE);
		double sy = div(height, srcHeight, DEFAUT_DIV_SCALE);

		if (IMAGE_TYPE_PNG.equals(this.targetImageType)) {
			final AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(sx, sy), null);
			this.targetImage = op.filter(toBufferedImage(srcImg), null);
		} else {
			this.targetImage = srcImg.getScaledInstance(width, height, scaleType);
		}

		return this;
	}

	/**
	 * {@link Image} 转 {@link BufferedImage}<br>
	 * 首先尝试强转，否则新建一个{@link BufferedImage}后重新绘制
	 *
	 * @param img {@link Image}
	 * @return {@link BufferedImage}
	 */
	public static BufferedImage toBufferedImage(Image img) {
		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}
		return copyImage(img, BufferedImage.TYPE_INT_RGB);
	}

	/**
	 * 将已有Image复制新的一份出来
	 *
	 * @param img       {@link Image}
	 * @param imageType 目标图片类型，{@link BufferedImage}中的常量，例如黑白等
	 * @return {@link BufferedImage}
	 * @see BufferedImage#TYPE_INT_RGB
	 * @see BufferedImage#TYPE_INT_ARGB
	 * @see BufferedImage#TYPE_INT_ARGB_PRE
	 * @see BufferedImage#TYPE_INT_BGR
	 * @see BufferedImage#TYPE_3BYTE_BGR
	 * @see BufferedImage#TYPE_4BYTE_ABGR
	 * @see BufferedImage#TYPE_4BYTE_ABGR_PRE
	 * @see BufferedImage#TYPE_BYTE_GRAY
	 * @see BufferedImage#TYPE_USHORT_GRAY
	 * @see BufferedImage#TYPE_BYTE_BINARY
	 * @see BufferedImage#TYPE_BYTE_INDEXED
	 * @see BufferedImage#TYPE_USHORT_565_RGB
	 * @see BufferedImage#TYPE_USHORT_555_RGB
	 * @since 4.5.17
	 */
	public static BufferedImage copyImage(Image img, int imageType) {
		final BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), imageType);
		final Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();
		return bimage;
	}

	/**
	 * 获取有效的源图片，首先检查上一次处理的结果图片，如无则使用用户传入的源图片
	 *
	 * @return 有效的源图片
	 */
	private Image getValidSrcImg() {
		return defaultIfNull(this.targetImage, this.srcImage);
	}

	/**
	 * 如果给定对象为{@code null}返回默认值
	 *
	 * <pre>
	 * ObjectUtil.defaultIfNull(null, null)      = null
	 * ObjectUtil.defaultIfNull(null, "")        = ""
	 * ObjectUtil.defaultIfNull(null, "zz")      = "zz"
	 * ObjectUtil.defaultIfNull("abc", *)        = "abc"
	 * ObjectUtil.defaultIfNull(Boolean.TRUE, *) = Boolean.TRUE
	 * </pre>
	 *
	 * @param <T>          对象类型
	 * @param object       被检查对象，可能为{@code null}
	 * @param defaultValue 被检查对象为{@code null}返回的默认值，可以为{@code null}
	 * @return 被检查对象为{@code null}返回默认值，否则返回原值
	 * @since 3.0.7
	 */
	public static <T> T defaultIfNull(final T object, final T defaultValue) {
		return (null != object) ? object : defaultValue;
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度,后面的四舍五入
	 *
	 * @param v1    被除数
	 * @param v2    除数
	 * @param scale 精确度，如果为负值，取绝对值
	 * @return 两个参数的商
	 */
	public static double div(float v1, float v2, int scale) {
		return div(v1, v2, scale, RoundingMode.HALF_UP);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
	 *
	 * @param v1           被除数
	 * @param v2           除数
	 * @param scale        精确度，如果为负值，取绝对值
	 * @param roundingMode 保留小数的模式 {@link RoundingMode}
	 * @return 两个参数的商
	 */
	public static double div(float v1, float v2, int scale, RoundingMode roundingMode) {
		return div(Float.toString(v1), Float.toString(v2), scale, roundingMode).doubleValue();
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
	 *
	 * @param v1           被除数
	 * @param v2           除数
	 * @param scale        精确度，如果为负值，取绝对值
	 * @param roundingMode 保留小数的模式 {@link RoundingMode}
	 * @return 两个参数的商
	 */
	public static BigDecimal div(String v1, String v2, int scale, RoundingMode roundingMode) {
		return div(new BigDecimal(v1), new BigDecimal(v2), scale, roundingMode);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
	 *
	 * @param v1           被除数
	 * @param v2           除数
	 * @param scale        精确度，如果为负值，取绝对值
	 * @param roundingMode 保留小数的模式 {@link RoundingMode}
	 * @return 两个参数的商
	 * @since 3.0.9
	 */
	public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale, RoundingMode roundingMode) {
		if (null == v1) {
			return BigDecimal.ZERO;
		}
		if (scale < 0) {
			scale = -scale;
		}
		return v1.divide(v2, scale, roundingMode);
	}

	/**
	 * 获取int类型的图片类型
	 *
	 * @return 图片类型
	 * @see BufferedImage#TYPE_INT_ARGB
	 * @see BufferedImage#TYPE_INT_RGB
	 */
	private int getTypeInt() {
		switch (this.targetImageType) {
		case IMAGE_TYPE_PNG:
			return BufferedImage.TYPE_INT_ARGB;
		default:
			return BufferedImage.TYPE_INT_RGB;
		}
	}

	/**
	 * 写出图像为目标文件扩展名对应的格式
	 *
	 * @param targetFile 目标文件
	 * @return 是否成功写出，如果返回false表示未找到合适的Writer
	 * @throws IOException
	 */
	public boolean write(File targetFile) throws IOException {
		final String formatName = getImageType(targetFile);
		if (StringUtils.isNotBlank(formatName)) {
			this.targetImageType = formatName;
		}

		if (targetFile.exists()) {
			targetFile.delete();
		}

		ImageOutputStream out = null;
		try {
			out = ImageIO.createImageOutputStream(targetFile);
			if (out == null) {
				throw new IllegalArgumentException(
						"Image type of file [" + targetFile.getName() + "] is not supported!");
			}
			return write(out);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 写出图像为PNG格式
	 *
	 * @param targetImageStream 写出到的目标流
	 * @return 是否成功写出，如果返回false表示未找到合适的Writer
	 * @throws IOException
	 */
	public boolean write(ImageOutputStream targetImageStream) throws IOException {
		final Image targetImage = (null == this.targetImage) ? this.srcImage : this.targetImage;
		String imageType = StringUtils.isBlank(this.targetImageType) ? IMAGE_TYPE_JPG : this.targetImageType;
		final ImageWriter writer = getWriter(targetImage, imageType);
		return write(toBufferedImage(targetImage, imageType), writer, targetImageStream, this.quality);
	}

	/**
	 * 通过{@link ImageWriter}写出图片到输出流
	 *
	 * @param image   图片
	 * @param writer  {@link ImageWriter}
	 * @param output  输出的Image流{@link ImageOutputStream}
	 * @param quality 质量，数字为0~1（不包括0和1）表示质量压缩比，除此数字外设置表示不压缩
	 * @return 是否成功写出
	 * @throws IOException
	 * @since 4.3.2
	 */
	public static boolean write(Image image, ImageWriter writer, ImageOutputStream output, float quality)
			throws IOException {
		if (writer == null) {
			return false;
		}

		writer.setOutput(output);
		final RenderedImage renderedImage = toRenderedImage(image);
		// 设置质量
		ImageWriteParam imgWriteParams = null;
		if (quality > 0 && quality < 1) {
			imgWriteParams = writer.getDefaultWriteParam();
			if (imgWriteParams.canWriteCompressed()) {
				imgWriteParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
				imgWriteParams.setCompressionQuality(quality);
				final ColorModel colorModel = renderedImage.getColorModel();
				imgWriteParams.setDestinationType(
						new ImageTypeSpecifier(colorModel, colorModel.createCompatibleSampleModel(16, 16)));
			}
		}

		try {
			if (null != imgWriteParams) {
				writer.write(null, new IIOImage(renderedImage, null, null), imgWriteParams);
			} else {
				writer.write(renderedImage);
			}
			output.flush();
		} catch (IOException e) {
			throw new IOException();
		} finally {
			writer.dispose();
		}
		return true;
	}

	/**
	 * {@link Image} 转 {@link BufferedImage}<br>
	 * 如果源图片的RGB模式与目标模式一致，则直接转换，否则重新绘制
	 *
	 * @param image     {@link Image}
	 * @param imageType 目标图片类型
	 * @return {@link BufferedImage}
	 * @since 4.3.2
	 */
	public static BufferedImage toBufferedImage(Image image, String imageType) {
		BufferedImage bufferedImage;
		if (false == imageType.equalsIgnoreCase(IMAGE_TYPE_PNG)) {
			// 当目标为非PNG类图片时，源图片统一转换为RGB格式
			if (image instanceof BufferedImage) {
				bufferedImage = (BufferedImage) image;
				if (BufferedImage.TYPE_INT_RGB != bufferedImage.getType()) {
					bufferedImage = copyImage(image, BufferedImage.TYPE_INT_RGB);
				}
			} else {
				bufferedImage = copyImage(image, BufferedImage.TYPE_INT_RGB);
			}
		} else {
			bufferedImage = toBufferedImage(image);
		}
		return bufferedImage;
	}

	/**
	 * 根据给定的Image对象和格式获取对应的{@link ImageWriter}，如果未找到合适的Writer，返回null
	 *
	 * @param img        {@link Image}
	 * @param formatName 图片格式，例如"jpg"、"png"
	 * @return {@link ImageWriter}
	 * @since 4.3.2
	 */
	public static ImageWriter getWriter(Image img, String formatName) {
		final ImageTypeSpecifier type = ImageTypeSpecifier.createFromRenderedImage(toRenderedImage(img));
		final Iterator<ImageWriter> iter = ImageIO.getImageWriters(type, formatName);
		return iter.hasNext() ? iter.next() : null;
	}

	/**
	 * {@link Image} 转 {@link RenderedImage}<br>
	 * 首先尝试强转，否则新建一个{@link BufferedImage}后重新绘制
	 *
	 * @param img {@link Image}
	 * @return {@link BufferedImage}
	 * @since 4.3.2
	 */
	public static RenderedImage toRenderedImage(Image img) {
		if (img instanceof RenderedImage) {
			return (RenderedImage) img;
		}
		return copyImage(img, BufferedImage.TYPE_INT_RGB);
	}

	/**
	 * 获取图片后缀名
	 * 
	 * @param destImageFile 源图片
	 * @return 图片后缀名
	 */
	public static String getImageType(File destImageFile) {
		return destImageFile.getName().substring(destImageFile.getName().lastIndexOf(".") + 1);
	}
}
