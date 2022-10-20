package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 * PDFBox添加文档
 * 
 * @author kst
 * @version 创建时间：2020年1月13日 上午10:26:53
 */
public class AddingContent {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// Loading an existing document
		File file = new File("C:/kang/image/pdfbox/blank.pdf");
		PDDocument document = PDDocument.load(file);

		// Retrieving the pages of the document
		PDPage page = document.getPage(0);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		// Begin the Content stream
		contentStream.beginText();
		// contentStream.set
		// Setting the font to the Content stream
//		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
//		contentStream.setFont(PDType1Font.SYMBOL, 14);
		contentStream.setFont(PDTrueTypeFont.loadTTF(document, new File("C:\\Windows\\Fonts\\SIMYOU.TTF")), 10);
		

		// Setting the position for the line
		contentStream.newLineAtOffset(25, 500);

		String text = "That is my first document中文";

		// Adding text in the form of string
		contentStream.showText(text);

		// Ending the content stream
		contentStream.endText();

		System.out.println("Content added");

		// Closing the content stream
		contentStream.close();

		// Saving the document
		document.save(new File("C:\\kang\\image\\pdfbox\\new-doc-text.pdf"));

		// Closing the document
		document.close();
	}

}
