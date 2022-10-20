package com.frank.test;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用Iterator迭代器的方式来解析xml
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
			// 已知属性名称情况下
			System.out.println("id: " + element.attributeValue("id"));
			// 未知属性名称情况下
//			Iterator attrIt = element.attributeIterator();
//			while(attrIt.hasNext()){
//				Attribute attr = (Attribute) attrIt.next();
//				System.out.println(attr.getName()+":"+attr.getValue());
//			}
			// 已知元素名情况下
//			System.out.println("title:"+element.elementText("title"));
//			System.out.println("author:"+element.elementText("author"));
			// 未知元素名情况下
			Iterator eleIt = element.elementIterator();
			while(eleIt.hasNext()){
				Element ele = (Element) eleIt.next();	
				System.out.println(ele.getName()+":"+ele.getText());
			}
		}
	}

}
