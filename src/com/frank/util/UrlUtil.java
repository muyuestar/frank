package com.frank.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Url������
 * 
 * @author kst 2019-09-16
 *
 */
public class UrlUtil {
	/**
	 * ������Url�������ļ�
	 * 
	 * @param urlStr
	 *            ����Url��ַ
	 * @param fileName
	 *            �ļ�����
	 * @param savePath
	 *            ����Ŀ¼
	 * @throws IOException
	 * @author kst 2019-09-16
	 */
	public static void downLoadFromUrl(String urlStr, String fileName, String savePath) {
		URL url;
		try {
			url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// ���ó�ʱ��Ϊ3��
			conn.setConnectTimeout(3 * 1000);
			// ��ֹ���γ���ץȡ������403����
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			// �õ�������
			InputStream is = conn.getInputStream();
			// ��ȡ�Լ�����
			byte[] getData = readInputStream(is);
			// �ļ�����λ��
			File saveDir = new File(savePath);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			File file = new File(saveDir + File.separator + fileName);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(getData);
			fos.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���������л�ȡ�ֽ�����
	 * 
	 * @param inputStream
	 *            ������
	 * @return �ֽ�����
	 * @throws IOException
	 * @author kst 2019-09-16
	 */
	public static byte[] readInputStream(InputStream inputStream) {
		ByteArrayOutputStream bos = null;
		try {
			byte[] buffer = new byte[1024];
			int len = 0;
			bos = new ByteArrayOutputStream();
			while ((len = inputStream.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bos.toByteArray();
	}
}
