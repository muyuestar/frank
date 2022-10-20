package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author kst
 * @version 创建时间：2020年1月13日 上午11:25:45
 */
public class AddMultipleLines {

	public static void main(String[] args) throws IOException {
		// Loading an existing document
		File file = new File("C:/kang/image/pdfbox/blank.pdf");
		PDDocument doc = PDDocument.load(file);

		// Creating a PDF Document
		PDPage page = doc.getPage(0);
		PDFont font = PDType0Font.load(doc, new File("c:/windows/fonts/times.ttf"));

		PDPageContentStream contentStream = new PDPageContentStream(doc, page);

		// Begin the Content stream
		contentStream.beginText();

		// Setting the font to the Content stream
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 16);
		System.out.println(" getName => " + font.getName());
		// contentStream.setFont( font, 16 );

		// Setting the leading
		contentStream.setLeading(14.5f);

		// Setting the position for the line
		contentStream.newLineAtOffset(25, 725);

		String text1 = "This is an example of adding text to a page in the pdf document. we can add as many lines";
		String text2 = "as we want like this using the ShowText()  method of the ContentStream class";
		// Adding text in the form of string
		contentStream.showText(text1);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(text2);
		contentStream.newLine();
		// Ending the content stream
		contentStream.endText();

		System.out.println("Content added");

		// Closing the content stream
		contentStream.close();

		// Saving the document
		doc.save(new File("C:\\kang\\image\\pdfbox\\new-mul-doc.pdf"));

		// Closing the document
		doc.close();
	}

}
