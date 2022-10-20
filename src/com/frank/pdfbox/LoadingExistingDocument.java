package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 * PDFBox加载文件
 * 
 * @author kst
 * @version 创建时间：2020年1月10日 上午9:47:11
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
