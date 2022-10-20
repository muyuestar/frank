//package com.frank.test;
//
//import java.io.ByteArrayOutputStream;
//import java.io.FileOutputStream;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.pdf.AcroFields;
//import com.itextpdf.text.pdf.PdfCopy;
//import com.itextpdf.text.pdf.PdfImportedPage;
//import com.itextpdf.text.pdf.PdfReader;
//import com.itextpdf.text.pdf.PdfStamper;
//
///**
// * @author kst
// * @date 2019-04-30 10:36:50
// */
//public class UpdatePdfFont2 {
//
//	public static void main(String[] args) throws Exception {
//		System.out.println("��ʼת��pdf");
//		String sourcePath = "E:/1.pdf";
//		String newPDFPath = "E:/2.pdf";
//		FileOutputStream out = null;
//		PdfReader reader = null;
//		ByteArrayOutputStream bos = null;
//		PdfStamper stamper = null;
//		try {
//			out = new FileOutputStream(newPDFPath); // �����
//			reader = new PdfReader(sourcePath); // ��ȡpdfģ��
//			bos = new ByteArrayOutputStream();
//			stamper = new PdfStamper(reader, bos);
//			AcroFields form = stamper.getAcroFields();
//			java.util.Iterator<String> it = form.getFields().keySet().iterator();
//			while (it.hasNext()) {
//				String name = it.next().toString();
//				form.setField(name, name);
//			}
//			stamper.setFormFlattening(true);
//			stamper.close();
//			Document doc = new Document();
//			PdfCopy copy = new PdfCopy(doc, out);
//			doc.open();
//			PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
//			copy.addPage(importPage);
//			doc.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("ת��pdf����");
//	}
//}
