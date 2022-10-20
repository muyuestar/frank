package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * PDFBox�ϲ����PDF�ĵ�
 * 
 * @author kst
 * @version ����ʱ�䣺2020��3��5�� ����10:29:30
 */
public class MergePDFs {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		// Loading an existing PDF document
		File file1 = new File("C:/kang/image/pdfbox/sample1.pdf");
		PDDocument doc1 = PDDocument.load(file1);

		File file2 = new File("C:/kang/image/pdfbox/sample2.pdf");
		PDDocument doc2 = PDDocument.load(file2);

		// Instantiating PDFMergerUtility class
		PDFMergerUtility PDFmerger = new PDFMergerUtility();

		// Setting the destination file
		PDFmerger.setDestinationFileName("C:/kang/image/pdfbox/merged.pdf");

		// adding the source files
		PDFmerger.addSource(file1);
		PDFmerger.addSource(file2);

		// Merging the two documents
		PDFmerger.mergeDocuments();

		System.out.println("Documents merged");
		// Closing the documents
		doc1.close();
		doc2.close();
	}

}
