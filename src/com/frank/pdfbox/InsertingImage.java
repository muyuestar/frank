package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 * PDFBox插入图像
 * 
 * @author kst
 * @version 创建时间：2020年1月16日 上午10:58:26
 */
public class InsertingImage {

	public static void main(String[] args) throws IOException {
		// Loading an existing document
		File file = new File("C:\\kang\\image\\pdfbox\\blank.pdf");
		PDDocument doc = PDDocument.load(file);

		// Retrieving the page
		PDPage page = doc.getPage(0);

		// Creating PDImageXObject object
		PDImageXObject pdImage = PDImageXObject.createFromFile("C:\\kang\\image\\pdfbox\\desktop.jpg", doc);

		// creating the PDPageContentStream object
		PDPageContentStream contents = new PDPageContentStream(doc, page);

		// Drawing the image in the PDF document
		contents.drawImage(pdImage, 0, 0);

		System.out.println("Image inserted");

		// Closing the PDPageContentStream object
		contents.close();

		// Saving the document
		doc.save("C:\\kang\\image\\pdfbox\\sample-image.pdf");

		// Closing the document
		doc.close();

	}

}
