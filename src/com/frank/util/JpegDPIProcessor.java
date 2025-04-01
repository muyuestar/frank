package com.frank.util;

import org.w3c.dom.Element;

import javax.imageio.*;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;

/**
 * @author: kst
 * @date: 2024/6/3 16:58
 */
public class JpegDPIProcessor implements ImageDPIProcessor {

    private String formatName = "jpeg";

    @Override
    public boolean canHandle(String fileName) {
        return fileName.endsWith("jpg") || fileName.endsWith("jpeg") || fileName.endsWith("JPG") || fileName.endsWith("JPEG");
    }

    @Override
    public byte[] process(BufferedImage image, int dpi) throws Exception {
        for (Iterator<ImageWriter> iw = ImageIO.getImageWritersByFormatName(formatName); iw.hasNext(); ) {
            ImageWriter writer = iw.next();
            ImageWriteParam writeParams = writer.getDefaultWriteParam();
            writeParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            writeParams.setCompressionQuality(1f);

            IIOMetadata data = writer.getDefaultImageMetadata(new ImageTypeSpecifier(image), writeParams);
            Element tree = (Element) data.getAsTree("javax_imageio_jpeg_image_1.0");
            Element jfif = (Element) tree.getElementsByTagName("app0JFIF").item(0);
            jfif.setAttribute("Xdensity", dpi + "");
            jfif.setAttribute("Ydensity", dpi + "");
            jfif.setAttribute("resUnits", "1");

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageOutputStream stream = null;
            try {
                stream = ImageIO.createImageOutputStream(out);
                writer.setOutput(stream);
                writer.write(data, new IIOImage(image, null, null), writeParams);
            } finally {
                stream.close();
            }
            return out.toByteArray();
        }
        return null;
    }
}
