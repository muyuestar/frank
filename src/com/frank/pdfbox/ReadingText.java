package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * PDFBox读取文档
 * 
 * @author kst
 * @version 创建时间：2020年1月14日 上午10:18:05
 */
public class ReadingText {

	public static void main(String[] args) throws IOException {
		// Loading an existing document
//		File file = new File("C:\\kang\\image\\pdfbox\\new-mul-doc.pdf");
		File file = new File("C:\\kang\\image\\pdfbox\\kst.pdf");
		PDDocument document = PDDocument.load(file);

		// Instantiate PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();

		// Retrieving text from PDF document
		String text = pdfStripper.getText(document);
		System.out.println(text);
		System.out.println("-----------------------------------");
		text = text.replaceAll("\\?", " ");
		System.out.println(text);
		// Closing the document
		document.close();
	}

}
