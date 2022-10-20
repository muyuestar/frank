package com.frank.pdfbox;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 * PDFBox添加页面
 * 
 * @author kst
 * @version 创建时间：2020年1月10日 上午9:37:18
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
