package com.frank.pdfbox;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

/**
 *
 * @author kst
 * @version 创建时间：2020年3月5日 上午10:56:57
 */
public class ShowColorBoxes {

	public static void main(String[] args) throws IOException {
		// Loading an existing document
		File file = new File("C:/kang/image/pdfbox/blank.pdf");
		PDDocument document = PDDocument.load(file);

		// Retrieving a page of the PDF Document
		PDPage page = document.getPage(0);

		// Instantiating the PDPageContentStream class
		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		// Setting the non stroking color
		contentStream.setNonStrokingColor(Color.green);

		// Drawing a rectangle
		contentStream.addRect(200, 500, 150, 100);

		// Drawing a rectangle
		contentStream.fill();

		System.out.println("rectangle added");

		// Closing the ContentStream object
		contentStream.close();

		// Saving the document
		File file1 = new File("C:/kang/image/pdfbox/colorbox.pdf");
		document.save(file1);

		// Closing the document
		document.close();
	}

}
