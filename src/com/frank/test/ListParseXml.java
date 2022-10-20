package com.frank.test;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 用List列表的方式来解析xml
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
		// 循环遍历二级节点
		for (Element child : childElements) {
			// 已知属性名情况下
//			System.out.println("id="+child.attributeValue("id"));
			// 未知属性名情况下
//			List<Attribute> attributeList = child.attributes();
//			for (Attribute attr : attributeList) {
//				System.out.println(attr.getName() + ": " + attr.getValue());
//			}
			// 已知子元素名的情况下
//			System.out.println("title="+child.elementText("title"));
//			System.out.println("author="+child.elementText("author"));
			// 未知子元素名情况下
			List<Element> elementList = child.elements();
			for (Element ele : elementList) { // 遍历三级节点
				System.out.println(ele.getName() + ":" + ele.getText());
			}
		}
	}

}
