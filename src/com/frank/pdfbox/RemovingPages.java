package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * PDFBoxɾ��ҳ��
 * 
 * @author kst
 * @version ����ʱ�䣺2020��1��10�� ����9:51:32
 */
public class RemovingPages {

	public static void main(String[] args) throws IOException {
		File file = new File("C:/kang/image/pdfbox/demo.pdf");
		PDDocument document = PDDocument.load(file);
		int noOfPages = document.getNumberOfPages();
		System.out.println(noOfPages);
		document.removePage(2);
		System.out.println("page removed");
		document.save("C:/kang/image/pdfbox/sample-remove-pages.pdf");
		document.close();
	}

}
