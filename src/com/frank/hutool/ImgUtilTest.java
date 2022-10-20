package com.frank.hutool;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import cn.hutool.core.img.ImgUtil;

/**
 *
 * @author kst
 * @date 2020-10-09 19:07:35
 */
public class ImgUtilTest {

	public static void main(String[] args) throws IOException {
		System.out.println("开始缩放图片");
		File srcImageFile = new File("C:/kang/image/1.jpg");
		File destImageFile = new File("C:/kang/image/1_fb.jpg");
//		int width = 226;
//		int height = 168;
		int width = 500;
		int height = 300;
		ImgUtil.scale(srcImageFile, destImageFile, width, height, null);
//		scale(srcImageFile, destImageFile, width, height, null);
		System.out.println("缩放图片结束");
	}

	public static void scale(File srcImageFile, File destImageFile, int width, int height, Color fixedColor)
			throws IOException {
		boolean flag = Img.from(srcImageFile).setTargetImageType(Img.getImageType(destImageFile)).scale(width, height)
				.write(destImageFile);
		System.out.println("flag=" + flag);
	}
}
