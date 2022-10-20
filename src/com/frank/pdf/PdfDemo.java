package com.frank.pdf;

import com.frank.util.PdfUtils;

/**
 * PDF������
 * 
 * @Author: kst
 * @Description:
 * @Date: 2019/7/11 18:18
 */
public class PdfDemo {
	public static void main(String[] args) throws Exception {
		// 1��PDF����ͼƬ
		// String pdfFilePath = "E:\\image\\smalltree.pdf";
		// String imgFilePath = "E:\\image\\smalltree.png";
		// long startTime = System.currentTimeMillis();
		// PdfUtils.pdfAddImage(pdfFilePath, imgFilePath);
		// long endTime = System.currentTimeMillis();
		// System.out.println("PDF���ͼƬ�ķ�ʱ�䣺" + (endTime - startTime));

		// 2��PDF����ͼƬ
		String originalPdfFilePath = "C:/kang/image/pdf/pdf.pdf";
		String composePdfFilePath = "C:/kang/image/pdf/pdf_1.pdf";
		String imgFilePath = "C:/Users/rensh/Desktop/1.jpg";
		long startTime = System.currentTimeMillis();
		PdfUtils.pdfAddImg(originalPdfFilePath, composePdfFilePath, imgFilePath, 220, 45, "58.5");
		long endTime = System.currentTimeMillis();
		System.out.println("PDF���ͼƬ�ķ�ʱ�䣺" + (endTime - startTime));

		// 3��pdfѭ��׷��ӡ��
		// String originalPdfFilePath = "E:\\image\\pdf\\pdf_";
		// String composePdfFilePath = "E:\\image\\produce\\wzh_";
		// String imgFilePath = "E:\\image\\seal\\seal_";
		// long startTime = System.currentTimeMillis();
		// for (int i = 1; i <= 5; i++) {
		// PdfUtils.pdfAddImg(originalPdfFilePath + i + ".pdf",
		// composePdfFilePath + i + ".pdf",
		// imgFilePath + i + ".png", 340, 15);
		// }
		// long endTime = System.currentTimeMillis();
		// System.out.println("PDF���ͼƬ�ķ�ʱ�䣺" + (endTime - startTime));

		// 4���ж�pdf�ļ��Ƿ�����
//		System.out.println("��ʼУ���ļ��Ƿ�����");
//		long startTime = System.currentTimeMillis();
//		String pdfFilePath = "E:\\image\\wzh.pdf";
//		System.out.println(PdfUtils.checkPdfFile(pdfFilePath));
//		long endTime = System.currentTimeMillis();
//		System.out.println("У���ļ��Ƿ�����ķ�ʱ�䣺" + (endTime - startTime));
//		System.out.println("У���ļ��Ƿ��������");
	}
}
