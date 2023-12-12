package com.frank.pdfbox;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 * PDFBox��ȡͼ��
 *
 * @author kst
 * @version ����ʱ�䣺2020��3��5�� ����10:41:51
 */
public class PdfToImage {

    public static void main(String[] args) throws IOException {
        // ��ҳ
        // Loading an existing PDF document
        File file = new File("C:/kang/image/pdfbox/mdm.pdf");
        PDDocument document = PDDocument.load(file);

        // Instantiating the PDFRenderer class
        PDFRenderer renderer = new PDFRenderer(document);

        // Rendering an image from the PDF document
        BufferedImage image = renderer.renderImageWithDPI(1, 144);

        // Writing the image to a file
        ImageIO.write(image, "JPEG", new File("C:/kang/image/pdfbox/myimage.jpg"));

        System.out.println("Image created");

        // Closing the document
        document.close();

    }

}
