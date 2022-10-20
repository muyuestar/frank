package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * PDFBox��ȡ�ĵ�
 * 
 * @author kst
 * @version ����ʱ�䣺2020��1��14�� ����10:18:05
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
