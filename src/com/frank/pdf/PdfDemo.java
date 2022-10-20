package com.frank.pdf;

import com.frank.util.PdfUtils;

/**
 * PDF测试类
 * 
 * @Author: kst
 * @Description:
 * @Date: 2019/7/11 18:18
 */
public class PdfDemo {
	public static void main(String[] args) throws Exception {
		// 1、PDF插入图片
		// String pdfFilePath = "E:\\image\\smalltree.pdf";
		// String imgFilePath = "E:\\image\\smalltree.png";
		// long startTime = System.currentTimeMillis();
		// PdfUtils.pdfAddImage(pdfFilePath, imgFilePath);
		// long endTime = System.currentTimeMillis();
		// System.out.println("PDF添加图片耗费时间：" + (endTime - startTime));

		// 2、PDF插入图片
		String originalPdfFilePath = "C:/kang/image/pdf/pdf.pdf";
		String composePdfFilePath = "C:/kang/image/pdf/pdf_1.pdf";
		String imgFilePath = "C:/Users/rensh/Desktop/1.jpg";
		long startTime = System.currentTimeMillis();
		PdfUtils.pdfAddImg(originalPdfFilePath, composePdfFilePath, imgFilePath, 220, 45, "58.5");
		long endTime = System.currentTimeMillis();
		System.out.println("PDF添加图片耗费时间：" + (endTime - startTime));

		// 3、pdf循环追加印章
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
		// System.out.println("PDF添加图片耗费时间：" + (endTime - startTime));

		// 4、判断pdf文件是否受损
//		System.out.println("开始校验文件是否受损");
//		long startTime = System.currentTimeMillis();
//		String pdfFilePath = "E:\\image\\wzh.pdf";
//		System.out.println(PdfUtils.checkPdfFile(pdfFilePath));
//		long endTime = System.currentTimeMillis();
//		System.out.println("校验文件是否受损耗费时间：" + (endTime - startTime));
//		System.out.println("校验文件是否受损结束");
	}
}
