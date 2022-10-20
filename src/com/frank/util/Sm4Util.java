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
 * SM4�ӽ���
 * 
 * @author kst
 * @date 2021-08-10 22:08:37
 *       https://www.cnblogs.com/Marydon20170307/p/9266946.html
 */
public class Sm4Util {

	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	// 128-32λ16���ƣ�256-64λ16����
	public static final int DEFAULT_KEY_NAME = 128;

	// ���ܷ�ʽ:SM4
	public static final String ALGORIGTHM_NAME = "SM4";

	// ����
	public static final String ENCODING = "UTF-8";

	// ����������ģʽʹ��
	public static final String ALGORITHM_NAME_ECB_PADDING = "SM4/ECB/PKCS7Padding";

	/**
	 * �Զ�������Կ
	 * 
	 * @return ��Կ
	 * @throws Exception
	 * @author kst,20210810
	 */
	public static byte[] generateKey() throws Exception {
		return generateKey(DEFAULT_KEY_NAME);
	}

	/**
	 * �Զ�������Կ
	 * 
	 * @param keySize
	 * @return ��Կ
	 * @throws Exception
	 * @author kst,20210810
	 */
	public static byte[] generateKey(int keySize) throws Exception {
		// java.lang.SecurityException: JCE cannot authenticate the provider BC�������
		// 1.C:\Program Files\Java\jre1.8.0_231\lib\security\java.security
		// ���security.provider.x=org.bouncycastle.jce.provider.BouncyCastleProvider
		// 2.C:\Program Files\Java\jre1.8.0_231\lib\ext������bcprov-jdk15on-1.69.jar
		KeyGenerator kg = KeyGenerator.getInstance(ALGORIGTHM_NAME, BouncyCastleProvider.PROVIDER_NAME);
		kg.init(keySize, new SecureRandom());
		return kg.generateKey().getEncoded();
	}

	/**
	 * sm4����
	 * 
	 * @exception ����ģʽ��ECB,���ĳ��Ȳ��̶���������ַ������ȱ仯
	 * @param hexKey   16������Կ(���Դ�Сд)
	 * @param paramStr �������ַ���
	 * @return ����16���Ƽ����ַ���
	 * @throws Exception
	 * @author kst,20210811
	 */
	public static String encryptEcb(String hexKey, String paramStr) throws Exception {
		// 16�����ַ�������>byte[]
		byte[] keyData = ByteUtils.fromHexString(hexKey);
		// String����>byte[]
		byte[] srcData = paramStr.getBytes(ENCODING);
		// ���ܺ������
		byte[] cipherArray = encryptEcbPadding(keyData, srcData);
		// byte[]����>hexString
		return ByteUtils.toHexString(cipherArray);
	}

	/**
	 * ��ȡ���ܺ������
	 * 
	 * @param key  key
	 * @param data data
	 * @return ���ܺ������
	 * @throws Exception
	 * @author kst,20210811
	 */
	public static byte[] encryptEcbPadding(byte[] key, byte[] data) throws Exception {
		Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(data);
	}

	/**
	 * ����ECB����
	 * 
	 * @param algorithmName �㷨����
	 * @param mode          ģʽ
	 * @param key           key
	 * @return ECB����
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

		// �Զ���32λ16������Կ
		System.out.println(encryptEcb("cc9368581322479ebf3e79348a2757d9", "123456"));
	}

}
