package com.frank.pdfbox;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * 
 * @author kst
 * @version ����ʱ�䣺2020��1��9�� ����4:47:50
 */
public class DocumentCreaion {

	public static void main(String[] args) throws IOException {
		// �����հ��ĵ�
		PDDocument document = new PDDocument();
		// �����ĵ�
		document.save("C:/kang/image/pdfbox/demo.pdf");
		// �ر��ĵ�
		document.close();
		System.out.println("pdf�����ɹ�");
	}
}
