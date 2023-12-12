package com.frank.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ���ַ��������������
 * 
 * @author panjianghong
 * @since 2016/8/31
 */
public class StringSort {

	private static final Log _log = LogFactory.getLog(StringSort.class);

	/**
	 * ���ַ��������������
	 * 
	 * @param keys
	 * @return
	 */
	public static String[] getUrlParam(String[] keys) {

		for (int i = 0; i < keys.length - 1; i++) {
			for (int j = 0; j < keys.length - i - 1; j++) {
				String pre = keys[j];
				String next = keys[j + 1];
				if (isMoreThan(pre, next)) {
					String temp = pre;
					keys[j] = next;
					keys[j + 1] = temp;
				}
			}
		}
		return keys;
	}

	/**
	 * �Ƚ������ַ����Ĵ�С������ĸ��ASCII��Ƚ�
	 * 
	 * @param pre
	 * @param next
	 * @return
	 */
	private static boolean isMoreThan(String pre, String next) {
		if (null == pre || null == next || "".equals(pre) || "".equals(next)) {
			_log.error("�ַ����Ƚ����ݲ���Ϊ�գ�");
			return false;
		}

		char[] c_pre = pre.toCharArray();
		char[] c_next = next.toCharArray();

		int minSize = Math.min(c_pre.length, c_next.length);

		for (int i = 0; i < minSize; i++) {
			if ((int) c_pre[i] > (int) c_next[i]) {
				return true;
			} else if ((int) c_pre[i] < (int) c_next[i]) {
				return false;
			}
		}
		if (c_pre.length > c_next.length) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		String pdfUrls = "WZHPT0100202003260000061226_atta_1.pdf|WZHPT0100202003260000061226_001_2_sign.pdf|WZHPT0100202003260000061226_atta_bc.pdf|WZHPT0100202003260000061226_atta_2.pdf|WZHPT0100202003260000061226_001_1_sign.pdf";
//		String[] keys = getUrlParam(new String[] { "fin", "abc", "shidema", "shide", "bushi" });
		String[] keys = getUrlParam(pdfUrls.split("\\|"));
		for (String key : keys) {
			System.out.println(key);
		}
	}
}