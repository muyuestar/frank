package com.frank.util;

import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

/**
 * SM4加解密
 * 
 * @author kst
 * @date 2021-08-10 22:08:37
 *       https://www.cnblogs.com/Marydon20170307/p/9266946.html
 */
public class Sm4Util {

	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	// 128-32位16进制；256-64位16进制
	public static final int DEFAULT_KEY_NAME = 128;

	// 加密方式:SM4
	public static final String ALGORIGTHM_NAME = "SM4";

	// 编码
	public static final String ENCODING = "UTF-8";

	// 定义分组加密模式使用
	public static final String ALGORITHM_NAME_ECB_PADDING = "SM4/ECB/PKCS7Padding";

	/**
	 * 自动生成密钥
	 * 
	 * @return 密钥
	 * @throws Exception
	 * @author kst,20210810
	 */
	public static byte[] generateKey() throws Exception {
		return generateKey(DEFAULT_KEY_NAME);
	}

	/**
	 * 自动生成密钥
	 * 
	 * @param keySize
	 * @return 密钥
	 * @throws Exception
	 * @author kst,20210810
	 */
	public static byte[] generateKey(int keySize) throws Exception {
		// java.lang.SecurityException: JCE cannot authenticate the provider BC解决方法
		// 1.C:\Program Files\Java\jre1.8.0_231\lib\security\java.security
		// 添加security.provider.x=org.bouncycastle.jce.provider.BouncyCastleProvider
		// 2.C:\Program Files\Java\jre1.8.0_231\lib\ext，引入bcprov-jdk15on-1.69.jar
		KeyGenerator kg = KeyGenerator.getInstance(ALGORIGTHM_NAME, BouncyCastleProvider.PROVIDER_NAME);
		kg.init(keySize, new SecureRandom());
		return kg.generateKey().getEncoded();
	}

	/**
	 * sm4加密
	 * 
	 * @exception 加密模式：ECB,密文长度不固定，随加密字符串长度变化
	 * @param hexKey   16进制密钥(忽略大小写)
	 * @param paramStr 待加密字符串
	 * @return 返回16进制加密字符串
	 * @throws Exception
	 * @author kst,20210811
	 */
	public static String encryptEcb(String hexKey, String paramStr) throws Exception {
		// 16进制字符串——>byte[]
		byte[] keyData = ByteUtils.fromHexString(hexKey);
		// String——>byte[]
		byte[] srcData = paramStr.getBytes(ENCODING);
		// 加密后的数组
		byte[] cipherArray = encryptEcbPadding(keyData, srcData);
		// byte[]——>hexString
		return ByteUtils.toHexString(cipherArray);
	}

	/**
	 * 获取加密后的数组
	 * 
	 * @param key  key
	 * @param data data
	 * @return 加密后的数组
	 * @throws Exception
	 * @author kst,20210811
	 */
	public static byte[] encryptEcbPadding(byte[] key, byte[] data) throws Exception {
		Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(data);
	}

	/**
	 * 生成ECB暗号
	 * 
	 * @param algorithmName 算法名称
	 * @param mode          模式
	 * @param key           key
	 * @return ECB暗号
	 * @throws Exception
	 * @author kst,20210811
	 */
	public static Cipher generateEcbCipher(String algorithmName, int mode, byte[] key) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
		Key sm4Key = new SecretKeySpec(key, ALGORIGTHM_NAME);
		cipher.init(mode, sm4Key);
		return cipher;
	}

	public static void main(String[] args) throws Exception {
//		byte[] keyBytes = generateKey();
//		System.out.println(new String(keyBytes));

		// 自定义32位16进制密钥
		System.out.println(encryptEcb("cc9368581322479ebf3e79348a2757d9", "123456"));
	}

}
