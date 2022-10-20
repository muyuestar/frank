package com.frank.test;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ��List�б�ķ�ʽ������xml
 * @author Administrator
 *
 */
public class ListParseXml {
	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		File file = new File("./xml/book.xml");
		Document document = reader.read(file);
		Element element = document.getRootElement();
		List<Element> childElements = element.elements();
		// ѭ�����������ڵ�
		for (Element child : childElements) {
			// ��֪�����������
//			System.out.println("id="+child.attributeValue("id"));
			// δ֪�����������
//			List<Attribute> attributeList = child.attributes();
//			for (Attribute attr : attributeList) {
//				System.out.println(attr.getName() + ": " + attr.getValue());
//			}
			// ��֪��Ԫ�����������
//			System.out.println("title="+child.elementText("title"));
//			System.out.println("author="+child.elementText("author"));
			// δ֪��Ԫ���������
			List<Element> elementList = child.elements();
			for (Element ele : elementList) { // ���������ڵ�
				System.out.println(ele.getName() + ":" + ele.getText());
			}
		}
	}

}
