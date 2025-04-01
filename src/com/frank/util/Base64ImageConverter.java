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
                System.out.println("生成图片失败");
                return null;
            }
            return Imaging.getBufferedImage(new File(imageFilePath));
        } catch (Exception e) {
            return null;
        }
    }

    public static BufferedImage drawOnWhiteBackground(BufferedImage originalImage, int backgroundSize) {
        // 创建一个白色背景的新图片
        BufferedImage whiteBackgroundImage = new BufferedImage(backgroundSize, backgroundSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = whiteBackgroundImage.createGraphics();
        // 设置背景颜色为白色
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, backgroundSize, backgroundSize);
        // 将原图绘制在白色背景上
        g2d.drawImage(originalImage, (backgroundSize - originalImage.getWidth()) / 2, (backgroundSize - originalImage.getHeight()) / 2, null);
        // 释放图形上下文使用的系统资源
        g2d.dispose();
        return whiteBackgroundImage;
    }

    /**
     * base64字符串转化成图片
     *
     * @param base64Str     base64字符串
     * @param imageFilePath 图片路径
     * @return true:生成成功，false:生成失败
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
            // 解码Base64图片数据
            BufferedImage originalImage = convertBase64ToImage(base64Image);
            if (originalImage == null) {
                return;
            }
            // 绘制在白色背景上
            BufferedImage whiteBackgroundImage = drawOnWhiteBackground(originalImage, 500);
            // 可以选择将结果图片保存到文件
            ImageIO.write(whiteBackgroundImage, "png", new File("C:/kang/image/zt/white_background_image.png"));
            System.out.println("成功");
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
//        System.out.println("成功");

    }
}