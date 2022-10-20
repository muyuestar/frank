package com.frank.pdfbox;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 * �����ĵ�����
 * 
 * @author kst
 * @version ����ʱ�䣺2020��1��13�� ����9:39:16
 */
public class AddingDocumentAttributes {

	public static void main(String[] args) throws IOException {
		// Creating PDF document object
		PDDocument document = new PDDocument();

		// Creating a blank page
		PDPage blankPage = new PDPage();

		// Adding the blank page to the document
		document.addPage(blankPage);

		// Creating the PDDocumentInformation object
		PDDocumentInformation pdd = document.getDocumentInformation();

		// Setting the author of the document
		pdd.setAuthor("frank");

		// Setting the title of the document
		pdd.setTitle("һ���򵥵��ĵ�����");

		// Setting the creator of the document
		pdd.setCreator("PDF Examples");

		// Setting the subject of the document
		pdd.setSubject("�ĵ�����");

		// Setting the created date of the document
		Calendar date = new GregorianCalendar();
		date.set(2017, 11, 5);
		pdd.setCreationDate(date);
		// Setting the modified date of the document
		date.set(2018, 10, 5);
		pdd.setModificationDate(date);

		// Setting keywords for the document
		pdd.setKeywords("pdfbox, first example, my pdf");

		// Saving the document
		document.save("C:/kang/image/pdfbox/doc_attributes.pdf");

		System.out.println("Properties added successfully ");

		// Closing the document
		document.close();
	}

}
