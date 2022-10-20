package com.frank.test;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

/**
 * ������ҳURL��Ƶ
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
			// ����һ��URIʵ��
			URI uri = URI.create(url);
			// ��ȡ��ǰϵͳ������չ
			Desktop dp = Desktop.getDesktop();
			// �ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ���
			if (dp.isSupported(Desktop.Action.BROWSE)) {
				// ��ȡϵͳĬ�������������
				dp.browse(uri);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
