package com.frank.util;

import org.apache.commons.imaging.Imaging;
import org.apache.commons.io.FileUtils;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.List;

/**
 *
 */
public class Base64ImageConverter {

    private static String imageFilePath = "C:/kang/image/zt/hehe.jpg";

    public static BufferedImage convertBase64ToImage(String base64ImageData) {
        try {
            if (!base64StrToImg(base64ImageData, imageFilePath)) {
                System.out.println("����ͼƬʧ��");
                return null;
            }
            return Imaging.getBufferedImage(new File(imageFilePath));
        } catch (Exception e) {
            return null;
        }
    }

    public static BufferedImage drawOnWhiteBackground(BufferedImage originalImage, int backgroundSize) {
        // ����һ����ɫ��������ͼƬ
        BufferedImage whiteBackgroundImage = new BufferedImage(backgroundSize, backgroundSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = whiteBackgroundImage.createGraphics();
        // ���ñ�����ɫΪ��ɫ
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, backgroundSize, backgroundSize);
        // ��ԭͼ�����ڰ�ɫ������
        g2d.drawImage(originalImage, (backgroundSize - originalImage.getWidth()) / 2, (backgroundSize - originalImage.getHeight()) / 2, null);
        // �ͷ�ͼ��������ʹ�õ�ϵͳ��Դ
        g2d.dispose();
        return whiteBackgroundImage;
    }

    /**
     * base64�ַ���ת����ͼƬ
     *
     * @param base64Str     base64�ַ���
     * @param imageFilePath ͼƬ·��
     * @return true:���ɳɹ���false:����ʧ��
     */
    public static boolean base64StrToImg(String base64Str, String imageFilePath) {
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            byte[] b = decoder.decodeBuffer(base64Str);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            out = new FileOutputStream(imageFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            File file = new File("C:/kang/image/zt/demo.txt");
            List<String> lineList = FileUtils.readLines(file, "utf-8");
            String base64Image = lineList.get(0);
            // ����Base64ͼƬ����
            BufferedImage originalImage = convertBase64ToImage(base64Image);
            if (originalImage == null) {
                return;
            }
            // �����ڰ�ɫ������
            BufferedImage whiteBackgroundImage = drawOnWhiteBackground(originalImage, 500);
            // ����ѡ�񽫽��ͼƬ���浽�ļ�
            ImageIO.write(whiteBackgroundImage, "png", new File("C:/kang/image/zt/white_background_image.png"));
            System.out.println("�ɹ�");
        } catch (IOException e) {
            e.printStackTrace();
        }


//        String path = "C:/kang/image/zt/haha1.jpg";
//        File imageFile = new File(path);
//        ImageInfo imageInfo = Imaging.getImageInfo(imageFile);
//        System.out.println("imageInfo:" + imageInfo);

//        String path = "C:/kang/image/zt/haha.jpg";
//        File imageFile = new File(path);
//        BufferedImage bufferedImage = Imaging.getBufferedImage(imageFile);
//        System.out.println("�ɹ�");

    }
}