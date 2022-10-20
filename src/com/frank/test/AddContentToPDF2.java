//package com.frank.test;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfContentByte;
//import com.itextpdf.text.pdf.PdfReader;
//import com.itextpdf.text.pdf.PdfStamper;
//
///**
// * java利用itext编辑pdf
// * 
// * @author kst
// * @date 2019-04-30 10:37:17
// */
//public class AddContentToPDF2 {
//
//	public static void main(String[] args) throws IOException, DocumentException {
//		PdfReader reader = new PdfReader("E:/1.pdf");
//		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("E:/2.pdf"));
//		BaseFont bfHei = BaseFont.createFont("C:/Windows/Fonts/simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//		Font font = new Font(bfHei, 12);
//		PdfContentByte over = stamper.getOverContent(1);
//		over.setFontAndSize(font.getBaseFont(), 12);
//		stamper.close();
//		System.out.println("生成pdf成功");
//	}
//}
