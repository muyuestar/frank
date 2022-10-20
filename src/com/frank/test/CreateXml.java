package com.frank.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * ����xml�ĵ���������ļ�
 * 
 * @author Administrator
 *
 */
public class CreateXml {

	public static void main(String[] args) throws IOException {
		Document document = DocumentHelper.createDocument();
		Element books = document.addElement("books");
		// ���Ӹ��ڵ�
		// ������Ԫ��
		Element book1 = books.addElement("book1");
		Element title1 = book1.addElement("title");
		Element author1 = book1.addElement("author");

		Element book2 = books.addElement("book2");
		Element title2 = book2.addElement("title");
		Element author2 = book2.addElement("author");
		// Ϊ�ӽڵ��������
		book1.addAttribute("id", "001");
		// ΪԪ���������
		title1.setText("Harry Potter");
		author1.setText("J K. Rowling");
		// Ϊ�ӽڵ��������
		book2.addAttribute("id", "002");
		// ΪԪ���������
		title2.setText("Learning XML");
		author2.setText("Erik T. Ray");
		// ʵ���������ʽ����
		OutputFormat format = OutputFormat.createPrettyPrint();
		// �����������
		format.setEncoding("UTF-8");
		// ������Ҫд���File����
		File file = new File("D:" + File.separator + "book.xml");
		// ����XMLWriter���󣬹��캯���еĲ���Ϊ��Ҫ������ļ����͸�ʽ
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(file), format);
		// ��ʼд�룬write�����а������洴����Document����
		xmlWriter.write(document);
	}
}
