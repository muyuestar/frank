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
 * 创建xml文档并输出到文件
 * 
 * @author Administrator
 *
 */
public class CreateXml {

	public static void main(String[] args) throws IOException {
		Document document = DocumentHelper.createDocument();
		Element books = document.addElement("books");
		// 增加根节点
		// 增加子元素
		Element book1 = books.addElement("book1");
		Element title1 = book1.addElement("title");
		Element author1 = book1.addElement("author");

		Element book2 = books.addElement("book2");
		Element title2 = book2.addElement("title");
		Element author2 = book2.addElement("author");
		// 为子节点添加属性
		book1.addAttribute("id", "001");
		// 为元素添加内容
		title1.setText("Harry Potter");
		author1.setText("J K. Rowling");
		// 为子节点添加属性
		book2.addAttribute("id", "002");
		// 为元素添加内容
		title2.setText("Learning XML");
		author2.setText("Erik T. Ray");
		// 实例化输出格式对象
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 设置输出编码
		format.setEncoding("UTF-8");
		// 创建需要写入的File对象
		File file = new File("D:" + File.separator + "book.xml");
		// 生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(file), format);
		// 开始写入，write方法中包含上面创建的Document对象
		xmlWriter.write(document);
	}
}
