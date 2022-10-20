package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;

/**
 * PDFBox PDF文档中的JavaScript
 * 
 * @author kst
 * @version 创建时间：2020年1月17日 下午3:14:32
 */
public class AddJavaScript {

	public static void main(String[] args) throws IOException {
		// Loading an existing file
		File file = new File("C:\\kang\\image\\pdfbox\\blank.pdf");
		PDDocument document = PDDocument.load(file);

		String javaScript = "app.alert( {cMsg: 'this is an example', nIcon: 3,"
				+ " nType: 0, cTitle: 'PDFBox Javascript example’} );";

		// Creating PDActionJavaScript object
		PDActionJavaScript PDAjavascript = new PDActionJavaScript(javaScript);

		// Embedding java script
		document.getDocumentCatalog().setOpenAction(PDAjavascript);

		// Saving the document
		document.save(new File("C:\\kang\\image\\pdfbox\\smaple-js.pdf"));
		System.out.println("Data added to the given PDF");

		// Closing the document
		document.close();
	}

}
