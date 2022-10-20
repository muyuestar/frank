package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 * PDFBox�����ļ�
 * 
 * @author kst
 * @version ����ʱ�䣺2020��1��10�� ����9:47:11
 */
public class LoadingExistingDocument {

	public static void main(String[] args) throws IOException {
		File file = new File("C:/kang/image/pdfbox/blank.pdf");
		PDDocument document = PDDocument.load(file);
		System.out.println("PDF loaded");
		document.addPage(new PDPage());
		document.save("C:/kang/image/pdfbox/demo.pdf");
		document.close();
	}

}
