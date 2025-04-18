package com.frank.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

public class Base64Utils {
    /**
     * 字符串转换成base64字符串
     *
     * @param bstr byte数组
     * @return base64字符串
     */
    public static String encode(byte[] bstr) {
        return new BASE64Encoder().encode(bstr);
    }

    /**
     * base64字符串转换成byte数组
     *
     * @param str 字符串
     * @return byte数组
     * @throws IOException
     */
    public static byte[] decode(String str) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(str);
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

    /**
     * jpg to png
     *
     * @param jpgPath 需要被转换的jpg全路径带文件名
     * @param pngPath 转换之后png的全路径带文件名
     */
    public static void jpg2png(String jpgPath, String pngPath) {
        try {
            BufferedImage jpg = ImageIO.read(new File(jpgPath));
            BufferedImage png = new BufferedImage(jpg.getWidth(), jpg.getHeight(), BufferedImage.TYPE_INT_RGB);
            png.createGraphics().drawImage(jpg, 0, 0, Color.white, null);
            ImageIO.write(png, "png", new File(pngPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将图片转换成Base64编码
     *
     * @param imgFile 待处理图片地址
     * @return
     */
    public static String getImgBase(String imgFile) {
        // 将图片文件转化为二进制流
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 图片头
        //String imghead = "data:image/jpeg;base64,";
        return Base64.encodeBase64String(data);
    }


    public static void main(String[] args) throws Exception {
//		String base64Str = "data:image/jpeg;base64,Z9i6rOgEY8if6VwYBrm0yl21VMGBWT6j9LAFc23w/YEWzC3GjigFElHVYNbIl5oEk7taTw9XME1ZDOU5qAUI/D24ku2w8VBDSyMZ4ei5rWnB4pPckZtiUdq4m3Mg8miYkzcGTOle6uiztEngGGTjMUoG+4G3QXNhGJp4pTYnvE2FLsWqJNMwA7Lbu0Z8Iy6wJw/u+7vjhNmOCr8JF0hF20xkhZDQiO+y5WHUYnwjLrAnD+77u+OE2Y4KvwkXSEXbTGSFkNCI77LlYdRifCMusCcP7vu744TZjgq/CRdIRdtMZIWQ0IjvsuVh1GJ8Iy6wJw/u+7vjhNmOCr8JF0hFFw==";
//		String imageFilePath = "C:/kang/image/finger.jpg";
//		System.out.println(base64StrToImg(base64Str, imageFilePath));

//        String jpgPath = "C:/kang/image/base64/bestface.jpg";
//        String pngPath = "C:/kang/image/base64/bestfacep.png";
//        jpg2png(jpgPath,pngPath);
//        String str = getImgBase(pngPath);
//        System.out.println(str);

        String pngPath = "C:/kang/image/zt/1.jpg";
        String str = getImgBase(pngPath);
        System.out.println(str);

//        String base64Str = "/9j/4AAQSkZJRgABAQEAYABgAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAFVAoADASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD3CiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKA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RRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAf/2Q==";
//		String imageFilePath = "C:/kang/image/demo/signdata.jpg";
//		System.out.println(base64StrToImg(base64Str, imageFilePath));

//        File file = new File("C:/kang/image/demo.txt");
//        List<String> lineList = FileUtils.readLines(file, "utf-8");
//        String base64Str = lineList.get(0);
//        String imageFilePath = "C:/kang/image/bird.jpg";
//        System.out.println(base64StrToImg(base64Str, imageFilePath));
//        String str = getImgBase(imageFilePath);
//        System.out.println(str);
    }
}