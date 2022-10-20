//package com.frank.test;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfWriter;
//
///**
// * @author kst
// * @date 2019-04-30 10:36:50
// */
//public class UpdatePdfFont {
//
//	public static void main(String[] args) throws Exception {
//		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
//		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:/2.pdf"));
//		document.open();
//		BaseFont bfHei = BaseFont.createFont("C:/Windows/Fonts/simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//		Font font = new Font(bfHei, 12);
//		String text = "���Ǻ����ֲ��ԣ�������ʽ��ӡ���Ķ�������       ��ģ������";
//		
//		document.add(new Paragraph(text, font));
//		document.close();
//		System.out.println("����pdf�ɹ�");
//	}
//
//	/**
//	 * ���ı��ļ��е����ݶ��뵽buffer��
//	 * 
//	 * @param buffer
//	 *            buffer
//	 * @param filePath
//	 *            �ļ�·��
//	 * @throws IOException
//	 *             �쳣
//	 * @author cn.outofmemory
//	 * @date 2013-1-7
//	 */
//	public static String readToBuffer(String filePath) throws IOException {
//		StringBuffer sb = new StringBuffer();
//		InputStream is = new FileInputStream(filePath);
//		String line; // ��������ÿ�ж�ȡ������
//		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//		line = reader.readLine(); // ��ȡ��һ��
//		while (line != null) { // ��� line Ϊ��˵��������
//			sb.append(line); // ��������������ӵ� buffer ��
//			sb.append("\n"); // ��ӻ��з�
//			line = reader.readLine(); // ��ȡ��һ��
//		}
//		reader.close();
//		is.close();
//		return sb.toString();
//	}
//}
