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
//		String text = "这是黑体字测试！测试针式打印机的断针与字       迹模糊问题";
//		
//		document.add(new Paragraph(text, font));
//		document.close();
//		System.out.println("生成pdf成功");
//	}
//
//	/**
//	 * 将文本文件中的内容读入到buffer中
//	 * 
//	 * @param buffer
//	 *            buffer
//	 * @param filePath
//	 *            文件路径
//	 * @throws IOException
//	 *             异常
//	 * @author cn.outofmemory
//	 * @date 2013-1-7
//	 */
//	public static String readToBuffer(String filePath) throws IOException {
//		StringBuffer sb = new StringBuffer();
//		InputStream is = new FileInputStream(filePath);
//		String line; // 用来保存每行读取的内容
//		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//		line = reader.readLine(); // 读取第一行
//		while (line != null) { // 如果 line 为空说明读完了
//			sb.append(line); // 将读到的内容添加到 buffer 中
//			sb.append("\n"); // 添加换行符
//			line = reader.readLine(); // 读取下一行
//		}
//		reader.close();
//		is.close();
//		return sb.toString();
//	}
//}
