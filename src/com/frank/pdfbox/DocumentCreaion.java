package com.frank.pdfbox;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * 
 * @author kst
 * @version 创建时间：2020年1月9日 下午4:47:50
 */
public class DocumentCreaion {

	public static void main(String[] args) throws IOException {
		// 创建空白文档
		PDDocument document = new PDDocument();
		// 保存文档
		document.save("C:/kang/image/pdfbox/demo.pdf");
		// 关闭文档
		document.close();
		System.out.println("pdf创建成功");
	}
}
