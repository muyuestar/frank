package com.frank.test;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��Iterator�������ķ�ʽ������xml
 * @author Administrator
 *
 */
public class IteratorParseXml {

	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("./xml/book.xml"));
		Element root = document.getRootElement();
		Iterator iter = root.elementIterator();
		while (iter.hasNext()) {
			Element element = (Element) iter.next();
			// ��֪�������������
			System.out.println("id: " + element.attributeValue("id"));
			// δ֪�������������
//			Iterator attrIt = element.attributeIterator();
//			while(attrIt.hasNext()){
//				Attribute attr = (Attribute) attrIt.next();
//				System.out.println(attr.getName()+":"+attr.getValue());
//			}
			// ��֪Ԫ���������
//			System.out.println("title:"+element.elementText("title"));
//			System.out.println("author:"+element.elementText("author"));
			// δ֪Ԫ���������
			Iterator eleIt = element.elementIterator();
			while(eleIt.hasNext()){
				Element ele = (Element) eleIt.next();	
				System.out.println(ele.getName()+":"+ele.getText());
			}
		}
	}

}
