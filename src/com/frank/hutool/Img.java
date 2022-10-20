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
	 * Ŀ��ͼƬ�ļ���ʽ������д��
	 */
	private String targetImageType;

	/**
	 * Ĭ�ϳ������㾫��
	 */
	private static final int DEFAUT_DIV_SCALE = 10;

	/**
	 * ͼƬ�������������ѹ��
	 */
	private float quality = -1;

	// ������Ƭר����
	public static final String IMAGE_TYPE_JPG = "jpg";

	// ����ֲ����ͼ��
	public static final String IMAGE_TYPE_PNG = "png";

	/**
	 * ����
	 *
	 * @param srcImage        ��ԴͼƬ
	 * @param targetImageType Ŀ��ͼƬ����
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
	 * ���ļ���ȡͼƬ����ʼ����
	 *
	 * @param imageFile ͼƬ�ļ�
	 * @return {@link Img}
	 * @throws IOException
	 */
	public static Img from(File imageFile) throws IOException {
		return new Img(read(imageFile), null);
	}

	/**
	 * ���ļ��ж�ȡͼƬ
	 *
	 * @param imageFile ͼƬ�ļ�
	 * @return ͼƬ
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
	 * ����Ŀ��ͼƬ�ļ���ʽ������д��
	 *
	 * @param imgType ͼƬ��ʽ
	 * @return this
	 */
	public Img setTargetImageType(String imgType) {
		this.targetImageType = imgType;
		return this;
	}

	/**
	 * �ȱ�����ͼ�񣬴˷������հ��ո����ĳ���ȱ�����ͼƬ�����ճ������ű�����һ�ߵȱ����ţ��հײ�����䱳��ɫ<br>
	 * ���ź�Ĭ��Ϊjpeg��ʽ
	 *
	 * @param width  ���ź�Ŀ��
	 * @param height ���ź�ĸ߶�
	 * @return this
	 */
	public Img scale(int width, int height) {
		Image srcImage = getValidSrcImg();
		int srcHeight = srcImage.getHeight(null);
		int srcWidth = srcImage.getWidth(null);
		double heightRatio = div(height, srcHeight, DEFAUT_DIV_SCALE);
		double widthRatio = div(width, srcWidth, DEFAUT_DIV_SCALE);

		if (widthRatio == heightRatio) {
			// ����������ͬ��������ʱ���������ź��ͼƬ
			imageScale(width, height);
		} else if (widthRatio < heightRatio) {
			// �����ű�����Ͱ��տ�����
			imageScale(width, (int) (srcHeight * widthRatio));
		} else {
			// �����ո�����
			imageScale((int) (srcWidth * heightRatio), height);
		}

		// ��ȡ���ź���µĿ�͸�
		srcImage = getValidSrcImg();
		srcHeight = srcImage.getHeight(null);
		srcWidth = srcImage.getWidth(null);

		final BufferedImage image = new BufferedImage(width, height, getTypeInt());
		Graphics2D g = image.createGraphics();

		// ���м���ͼ
		g.drawImage(srcImage, (width - srcWidth) / 2, (height - srcHeight) / 2, srcWidth, srcHeight, null, null);
		g.dispose();
		this.targetImage = image;
		return this;
	}

	/**
	 * ����ͼ�񣨰��������ţ�<br>
	 * ע�⣺Ŀ�곤����ԭͼ���ɱ��������
	 *
	 * @param width  Ŀ����
	 * @param height Ŀ��߶�
	 * @return this
	 */
	public Img imageScale(int width, int height) {
		final Image srcImg = getValidSrcImg();

		int srcHeight = srcImg.getHeight(null);
		int srcWidth = srcImg.getWidth(null);
		int scaleType;
		if (srcHeight == height && srcWidth == width) {
			// Դ��Ŀ�곤��һ�·���ԭͼ
			this.targetImage = srcImg;
			return this;
		} else if (srcHeight < height || srcWidth < width) {
			// �Ŵ�ͼƬʹ��ƽ��ģʽ
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
	 * {@link Image} ת {@link BufferedImage}<br>
	 * ���ȳ���ǿת�������½�һ��{@link BufferedImage}�����»���
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
	 * ������Image�����µ�һ�ݳ���
	 *
	 * @param img       {@link Image}
	 * @param imageType Ŀ��ͼƬ���ͣ�{@link BufferedImage}�еĳ���������ڰ׵�
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
	 * ��ȡ��Ч��ԴͼƬ�����ȼ����һ�δ���Ľ��ͼƬ��������ʹ���û������ԴͼƬ
	 *
	 * @return ��Ч��ԴͼƬ
	 */
	private Image getValidSrcImg() {
		return defaultIfNull(this.targetImage, this.srcImage);
	}

	/**
	 * �����������Ϊ{@code null}����Ĭ��ֵ
	 *
	 * <pre>
	 * ObjectUtil.defaultIfNull(null, null)      = null
	 * ObjectUtil.defaultIfNull(null, "")        = ""
	 * ObjectUtil.defaultIfNull(null, "zz")      = "zz"
	 * ObjectUtil.defaultIfNull("abc", *)        = "abc"
	 * ObjectUtil.defaultIfNull(Boolean.TRUE, *) = Boolean.TRUE
	 * </pre>
	 *
	 * @param <T>          ��������
	 * @param object       �������󣬿���Ϊ{@code null}
	 * @param defaultValue ��������Ϊ{@code null}���ص�Ĭ��ֵ������Ϊ{@code null}
	 * @return ��������Ϊ{@code null}����Ĭ��ֵ�����򷵻�ԭֵ
	 * @since 3.0.7
	 */
	public static <T> T defaultIfNull(final T object, final T defaultValue) {
		return (null != object) ? object : defaultValue;
	}

	/**
	 * �ṩ(���)��ȷ�ĳ�������,�����������������ʱ,��scaleָ����ȷ��,�������������
	 *
	 * @param v1    ������
	 * @param v2    ����
	 * @param scale ��ȷ�ȣ����Ϊ��ֵ��ȡ����ֵ
	 * @return ������������
	 */
	public static double div(float v1, float v2, int scale) {
		return div(v1, v2, scale, RoundingMode.HALF_UP);
	}

	/**
	 * �ṩ(���)��ȷ�ĳ�������,�����������������ʱ,��scaleָ����ȷ��
	 *
	 * @param v1           ������
	 * @param v2           ����
	 * @param scale        ��ȷ�ȣ����Ϊ��ֵ��ȡ����ֵ
	 * @param roundingMode ����С����ģʽ {@link RoundingMode}
	 * @return ������������
	 */
	public static double div(float v1, float v2, int scale, RoundingMode roundingMode) {
		return div(Float.toString(v1), Float.toString(v2), scale, roundingMode).doubleValue();
	}

	/**
	 * �ṩ(���)��ȷ�ĳ�������,�����������������ʱ,��scaleָ����ȷ��
	 *
	 * @param v1           ������
	 * @param v2           ����
	 * @param scale        ��ȷ�ȣ����Ϊ��ֵ��ȡ����ֵ
	 * @param roundingMode ����С����ģʽ {@link RoundingMode}
	 * @return ������������
	 */
	public static BigDecimal div(String v1, String v2, int scale, RoundingMode roundingMode) {
		return div(new BigDecimal(v1), new BigDecimal(v2), scale, roundingMode);
	}

	/**
	 * �ṩ(���)��ȷ�ĳ�������,�����������������ʱ,��scaleָ����ȷ��
	 *
	 * @param v1           ������
	 * @param v2           ����
	 * @param scale        ��ȷ�ȣ����Ϊ��ֵ��ȡ����ֵ
	 * @param roundingMode ����С����ģʽ {@link RoundingMode}
	 * @return ������������
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
	 * ��ȡint���͵�ͼƬ����
	 *
	 * @return ͼƬ����
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
	 * д��ͼ��ΪĿ���ļ���չ����Ӧ�ĸ�ʽ
	 *
	 * @param targetFile Ŀ���ļ�
	 * @return �Ƿ�ɹ�д�����������false��ʾδ�ҵ����ʵ�Writer
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
	 * д��ͼ��ΪPNG��ʽ
	 *
	 * @param targetImageStream д������Ŀ����
	 * @return �Ƿ�ɹ�д�����������false��ʾδ�ҵ����ʵ�Writer
	 * @throws IOException
	 */
	public boolean write(ImageOutputStream targetImageStream) throws IOException {
		final Image targetImage = (null == this.targetImage) ? this.srcImage : this.targetImage;
		String imageType = StringUtils.isBlank(this.targetImageType) ? IMAGE_TYPE_JPG : this.targetImageType;
		final ImageWriter writer = getWriter(targetImage, imageType);
		return write(toBufferedImage(targetImage, imageType), writer, targetImageStream, this.quality);
	}

	/**
	 * ͨ��{@link ImageWriter}д��ͼƬ�������
	 *
	 * @param image   ͼƬ
	 * @param writer  {@link ImageWriter}
	 * @param output  �����Image��{@link ImageOutputStream}
	 * @param quality ����������Ϊ0~1��������0��1����ʾ����ѹ���ȣ��������������ñ�ʾ��ѹ��
	 * @return �Ƿ�ɹ�д��
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
		// ��������
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
	 * {@link Image} ת {@link BufferedImage}<br>
	 * ���ԴͼƬ��RGBģʽ��Ŀ��ģʽһ�£���ֱ��ת�����������»���
	 *
	 * @param image     {@link Image}
	 * @param imageType Ŀ��ͼƬ����
	 * @return {@link BufferedImage}
	 * @since 4.3.2
	 */
	public static BufferedImage toBufferedImage(Image image, String imageType) {
		BufferedImage bufferedImage;
		if (false == imageType.equalsIgnoreCase(IMAGE_TYPE_PNG)) {
			// ��Ŀ��Ϊ��PNG��ͼƬʱ��ԴͼƬͳһת��ΪRGB��ʽ
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
	 * ���ݸ�����Image����͸�ʽ��ȡ��Ӧ��{@link ImageWriter}�����δ�ҵ����ʵ�Writer������null
	 *
	 * @param img        {@link Image}
	 * @param formatName ͼƬ��ʽ������"jpg"��"png"
	 * @return {@link ImageWriter}
	 * @since 4.3.2
	 */
	public static ImageWriter getWriter(Image img, String formatName) {
		final ImageTypeSpecifier type = ImageTypeSpecifier.createFromRenderedImage(toRenderedImage(img));
		final Iterator<ImageWriter> iter = ImageIO.getImageWriters(type, formatName);
		return iter.hasNext() ? iter.next() : null;
	}

	/**
	 * {@link Image} ת {@link RenderedImage}<br>
	 * ���ȳ���ǿת�������½�һ��{@link BufferedImage}�����»���
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
	 * ��ȡͼƬ��׺��
	 * 
	 * @param destImageFile ԴͼƬ
	 * @return ͼƬ��׺��
	 */
	public static String getImageType(File destImageFile) {
		return destImageFile.getName().substring(destImageFile.getName().lastIndexOf(".") + 1);
	}
}
