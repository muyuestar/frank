package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

/**
 * 检索文档属性
 * 
 * @author kst
 * @version 创建时间：2020年1月13日 上午10:09:01
 */
public class RetrivingDocumentAttributes {

	public static void main(String[] args) throws IOException {
		// Loading an existing document
		File file = new File("C:/kang/image/pdfbox/doc_attributes.pdf");
		PDDocument document = PDDocument.load(file);
		// Getting the PDDocumentInformation object
		PDDocumentInformation pdd = document.getDocumentInformation();

		// Retrieving the info of a PDF document
		System.out.println("Author of the document is :" + pdd.getAuthor());
		System.out.println("Title of the document is :" + pdd.getTitle());
		System.out.println("Subject of the document is :" + pdd.getSubject());

		System.out.println("Creator of the document is :" + pdd.getCreator());
		System.out.println("Creation date of the document is :" + pdd.getCreationDate());
		System.out.println("Modification date of the document is :" + pdd.getModificationDate());
		System.out.println("Keywords of the document are :" + pdd.getKeywords());

		// Closing the document
		document.close();
	}

}
