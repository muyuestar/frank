package com.frank.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 * pdf转换成jpg
 * 
 * @author kst
 * @date 2019-05-08 11:58:51
 */
public class TestPdfTojpg {

	public static void main(String[] args) throws IOException {
		System.out.println("开始转换");
		long startTime = System.currentTimeMillis();
		File file = new File("E:\\wzh.pdf");
		try {
			PDDocument doc = PDDocument.load(file);
			PDFRenderer renderer = new PDFRenderer(doc);
			int pageCount = doc.getNumberOfPages();
			for (int i = 0; i < pageCount; i++) {
				BufferedImage image = renderer.renderImageWithDPI(i, 100);
				// BufferedImage image = renderer.renderImage(i, 2.5f);
				ImageIO.write(image, "png", new File("E:\\pdfbox.png"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("转换结束");
		System.out.println("时间：" + (endTime - startTime));
	}
}