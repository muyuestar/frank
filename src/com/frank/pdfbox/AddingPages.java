package com.frank.pdfbox;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 * PDFBox���ҳ��
 * 
 * @author kst
 * @version ����ʱ�䣺2020��1��10�� ����9:37:18
 */
public class AddingPages {

	public static void main(String[] args) throws IOException {
		PDDocument document = new PDDocument();
		for (int i = 0; i < 1; i++) {
			PDPage blankPage = new PDPage();
			document.addPage(blankPage);
		}
		document.save("C:/kang/image/pdfbox/blank.pdf");
		document.close();
		System.out.println("PDF created");
	}

}
