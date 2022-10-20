package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;

/**
 * PDFBox PDF�ĵ��е�JavaScript
 * 
 * @author kst
 * @version ����ʱ�䣺2020��1��17�� ����3:14:32
 */
public class AddJavaScript {

	public static void main(String[] args) throws IOException {
		// Loading an existing file
		File file = new File("C:\\kang\\image\\pdfbox\\blank.pdf");
		PDDocument document = PDDocument.load(file);

		String javaScript = "app.alert( {cMsg: 'this is an example', nIcon: 3,"
				+ " nType: 0, cTitle: 'PDFBox Javascript example��} );";

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
