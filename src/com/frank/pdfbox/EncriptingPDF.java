package com.frank.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

/**
 * PDFBox加密PDF文档
 * 
 * @author kst
 * @version 创建时间：2020年1月16日 上午11:24:58
 */
public class EncriptingPDF {

	public static void main(String[] args) throws IOException {
		// Loading an existing document
		File file = new File("C:\\kang\\image\\pdfbox\\blank.pdf");
		PDDocument document = PDDocument.load(file);

		// Creating access permission object
		AccessPermission ap = new AccessPermission();

		// Creating StandardProtectionPolicy object
		StandardProtectionPolicy spp = new StandardProtectionPolicy("123456", "123456", ap);

		// Setting the length of the encryption key
		spp.setEncryptionKeyLength(128);

		// Setting the access permissions
		spp.setPermissions(ap);

		// Protecting the document
		document.protect(spp);

		System.out.println("Document encrypted");

		// Saving the document
		document.save("C:\\kang\\image\\pdfbox\\sample-encript.pdf");
		// Closing the document
		document.close();
	}

}
