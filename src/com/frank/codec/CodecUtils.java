package com.frank.codec;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;

/**
 *
 * @author kst
 * @version 创建时间：2020年3月3日 下午11:01:02
 */
public class CodecUtils {

	public static void main(String[] args) throws UnsupportedEncodingException, DecoderException {
		// 1.Base64
		// 1.1.str->base64
//		byte[] binaryData = "晚上好".getBytes("utf-8");
//		String str = Base64.encodeBase64String(binaryData);
//		System.out.println(str);
		// 1.2.base64->str
//		byte[] byteString = Base64.decodeBase64(str);
//		System.out.println(new String(byteString,"utf-8"));

		// 2.MD5
		String data = "晚上好";
		String md5String = DigestUtils.md5Hex(data);
		System.out.println(md5String);

		// 3.URL
//		byte[] bytes = "https://www.baidu.com/".getBytes("utf-8");
//		byte[] decodeBytes = URLCodec.decodeUrl(bytes);
//		BitSet urlsafe = null;
//		URLCodec.encodeUrl(urlsafe, decodeBytes);
	}

}
