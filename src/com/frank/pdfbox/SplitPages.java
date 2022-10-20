package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * PDFBox分割PDF文档
 * 
 * @author kst
 * @version 创建时间：2020年3月5日 上午10:15:51
 */
public class SplitPages {

	public static void main(String[] args) throws IOException {
		// Loading an existing PDF document
		File file = new File("C:/kang/image/pdfbox/simple/mypdf.pdf");
		PDDocument document = PDDocument.load(file);

		// Instantiating Splitter class
		Splitter splitter = new Splitter();

		// splitting the pages of a PDF document
		List<PDDocument> Pages = splitter.split(document);

		// Creating an iterator
		Iterator<PDDocument> iterator = Pages.listIterator();

		// Saving each page as an individual document
		int i = 1;
		while (iterator.hasNext()) {
			PDDocument pd = iterator.next();
			pd.save("C:/kang/image/pdfbox/simple/sample" + i + ".pdf");
			i = i + 1;
		}
		System.out.println("Multiple PDF’s created");
		document.close();
	}

}
