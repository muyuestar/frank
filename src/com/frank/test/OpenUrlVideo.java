package com.frank.test;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

/**
 * 播放网页URL视频
 * 
 * @author kst
 *
 */
public class OpenUrlVideo {

	public static void main(String[] args) throws IOException {
		String url = "https://www.aliyun.com/";
//		if (!url.startsWith("http")) {
//			url = "http://" + url;
//		}
		try {
			// 创建一个URI实例
			URI uri = URI.create(url);
			// 获取当前系统桌面扩展
			Desktop dp = Desktop.getDesktop();
			// 判断系统桌面是否支持要执行的功能
			if (dp.isSupported(Desktop.Action.BROWSE)) {
				// 获取系统默认浏览器打开链接
				dp.browse(uri);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
