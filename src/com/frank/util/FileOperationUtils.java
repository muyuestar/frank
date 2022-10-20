package com.frank.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.sl.usermodel.TextRun;
import org.w3c.dom.Document;

/**
 * 文件操作类
 * 
 * @author kst
 * @date 2019-08-14 22:30:58
 */
public class FileOperationUtils {

	/**
	 * word转换成html
	 * 
	 * @param wordFilePath
	 *            word文件路径
	 * @param wordFileName
	 *            word文件名称
	 * @param htmlName
	 *            html文件名称
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void poiWordToHtml(String wordFilePath, String wordFileName, String htmlName) throws Exception {
		InputStream input = new FileInputStream(wordFilePath + wordFileName);
		HWPFDocument wordDocument = new HWPFDocument(input);
		WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
				DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
		wordToHtmlConverter.setPicturesManager(new PicturesManager() {
			public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches,
					float heightInches) {
				return suggestedName;
			}
		});
		wordToHtmlConverter.processDocument(wordDocument);
		List pics = wordDocument.getPicturesTable().getAllPictures();
		if (pics != null) {
			for (int i = 0; i < pics.size(); i++) {
				Picture pic = (Picture) pics.get(i);
				try {
					pic.writeImageContent(new FileOutputStream(wordFilePath + pic.suggestFullFileName()));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		Document htmlDocument = wordToHtmlConverter.getDocument();
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		DOMSource domSource = new DOMSource(htmlDocument);
		StreamResult streamResult = new StreamResult(outStream);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer serializer = tf.newTransformer();
		serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		serializer.setOutputProperty(OutputKeys.INDENT, "yes");
		serializer.setOutputProperty(OutputKeys.METHOD, "html");
		serializer.transform(domSource, streamResult);
		outStream.close();
		String content = new String(outStream.toByteArray());
		FileUtils.writeStringToFile(new File(wordFilePath, htmlName), content, "utf-8");
	}

	/**
	 * excel文件转换成html文件
	 * 
	 * @param excelFilePath
	 *            excel文件路径
	 * @param excelFileName
	 *            excel文件名称
	 * @param htmlName
	 *            html文件名称
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void poiExcelToHtml(String excelFilePath, String excelFileName, String htmlName) throws Exception {
		InputStream input = new FileInputStream(excelFilePath + excelFileName);
		HSSFWorkbook excelBook = new HSSFWorkbook(input);
		ExcelToHtmlConverter excelToHtmlConverter = new ExcelToHtmlConverter(
				DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
		excelToHtmlConverter.processWorkbook(excelBook);
		List pics = excelBook.getAllPictures();
		if (pics != null) {
			for (int i = 0; i < pics.size(); i++) {
				Picture pic = (Picture) pics.get(i);
				try {
					pic.writeImageContent(new FileOutputStream(excelFilePath + pic.suggestFullFileName()));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		Document htmlDocument = excelToHtmlConverter.getDocument();
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		DOMSource domSource = new DOMSource(htmlDocument);
		StreamResult streamResult = new StreamResult(outStream);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer serializer = tf.newTransformer();
		serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		serializer.setOutputProperty(OutputKeys.INDENT, "yes");
		serializer.setOutputProperty(OutputKeys.METHOD, "html");
		serializer.transform(domSource, streamResult);
		outStream.close();
		String content = new String(outStream.toByteArray());
		FileUtils.writeStringToFile(new File(excelFilePath, htmlName), content, "utf-8");
	}

	public static boolean poiPPTToHtml(File file) {
//		boolean isppt = checkFile(file);
//		if (!isppt) {
//			System.out.println("The image you specify don't exit!");
//			return false;
//		}
//		try {
//			FileInputStream is = new FileInputStream(file);
//			SlideShow ppt = new SlideShow(is);
//			is.close();
//			Dimension pgsize = ppt.getPageSize();
//			org.apache.poi.hslf.model.Slide[] slide = ppt.getSlides();
//			for (int i = 0; i < slide.length; i++) {
//				System.out.print("第" + i + "页。");
//
//				TextRun[] truns = slide[i].getTextRuns();
//				for (int k = 0; k < truns.length; k++) {
//					RichTextRun[] rtruns = truns[k].getRichTextRuns();
//					for (int l = 0; l < rtruns.length; l++) {
//						int index = rtruns[l].getFontIndex();
//						String name = rtruns[l].getFontName();
//						rtruns[l].setFontIndex(1);
//						rtruns[l].setFontName("宋体");
//						// System.out.println(rtruns[l].getText());
//					}
//				}
//				BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
//
//				Graphics2D graphics = img.createGraphics();
//				graphics.setPaint(Color.BLUE);
//				graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
//				slide[i].draw(graphics);
//
//				// 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
//				FileOutputStream out = new FileOutputStream("D:/poi-test/pptToImg/pict_" + (i + 1) + ".jpeg");
//				javax.imageio.ImageIO.write(img, "jpeg", out);
//				out.close();
//
//			}
//			System.out.println("success!!");
//			return true;
//		} catch (FileNotFoundException e) {
//			System.out.println(e);
//			// System.out.println("Can't find the image!");
//		} catch (IOException e) {
//		}
		return false;
	}

	/**
	 * 检查文件是否为PPT
	 * 
	 * @param file
	 *            文件
	 * @return true：是，false:否
	 */
	public static boolean checkFile(File file) {
		boolean isppt = false;
		String filename = file.getName();
		String suffixname = null;
		if (filename != null && filename.indexOf(".") != -1) {
			suffixname = filename.substring(filename.indexOf("."));
			if (suffixname.equals(".ppt")) {
				isppt = true;
			}
			return isppt;
		}
		return isppt;
	}
}
