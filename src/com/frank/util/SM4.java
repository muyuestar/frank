package com.frank.util;

import java.util.Arrays;

/**
 * SM4�㷨
 * 
 * @author kst
 * @date 2021-08-12 22:48:28
 */
public class SM4 {

	private static final int DECRYPT = 0;
	private static final int CBC = 0;
	private static final int ROUND = 32;
	private static final int BLOCK = 16;

	private int[] Sbox = { 0xd6, 0x90, 0xe9, 0xfe, 0xcc, 0xe1, 0x3d, 0xb7, 0x16, 0xb6, 0x14, 0xc2, 0x28, 0xfb, 0x2c,
			0x05, 0x2b, 0x67, 0x9a, 0x76, 0x2a, 0xbe, 0x04, 0xc3, 0xaa, 0x44, 0x13, 0x26, 0x49, 0x86, 0x06, 0x99, 0x9c,
			0x42, 0x50, 0xf4, 0x91, 0xef, 0x98, 0x7a, 0x33, 0x54, 0x0b, 0x43, 0xed, 0xcf, 0xac, 0x62, 0xe4, 0xb3, 0x1c,
			0xa9, 0xc9, 0x08, 0xe8, 0x95, 0x80, 0xdf, 0x94, 0xfa, 0x75, 0x8f, 0x3f, 0xa6, 0x47, 0x07, 0xa7, 0xfc, 0xf3,
			0x73, 0x17, 0xba, 0x83, 0x59, 0x3c, 0x19, 0xe6, 0x85, 0x4f, 0xa8, 0x68, 0x6b, 0x81, 0xb2, 0x71, 0x64, 0xda,
			0x8b, 0xf8, 0xeb, 0x0f, 0x4b, 0x70, 0x56, 0x9d, 0x35, 0x1e, 0x24, 0x0e, 0x5e, 0x63, 0x58, 0xd1, 0xa2, 0x25,
			0x22, 0x7c, 0x3b, 0x01, 0x21, 0x78, 0x87, 0xd4, 0x00, 0x46, 0x57, 0x9f, 0xd3, 0x27, 0x52, 0x4c, 0x36, 0x02,
			0xe7, 0xa0, 0xc4, 0xc8, 0x9e, 0xea, 0xbf, 0x8a, 0xd2, 0x40, 0xc7, 0x38, 0xb5, 0xa3, 0xf7, 0xf2, 0xce, 0xf9,
			0x61, 0x15, 0xa1, 0xe0, 0xae, 0x5d, 0xa4, 0x9b, 0x34, 0x1a, 0x55, 0xad, 0x93, 0x32, 0x30, 0xf5, 0x8c, 0xb1,
			0xe3, 0x1d, 0xf6, 0xe2, 0x2e, 0x82, 0x66, 0xca, 0x60, 0xc0, 0x29, 0x23, 0xab, 0x0d, 0x53, 0x4e, 0x6f, 0xd5,
			0xdb, 0x37, 0x45, 0xde, 0xfd, 0x8e, 0x2f, 0x03, 0xff, 0x6a, 0x72, 0x6d, 0x6c, 0x5b, 0x51, 0x8d, 0x1b, 0xaf,
			0x92, 0xbb, 0xdd, 0xbc, 0x7f, 0x11, 0xd9, 0x5c, 0x41, 0x1f, 0x10, 0x5a, 0xd8, 0x0a, 0xc1, 0x31, 0x88, 0xa5,
			0xcd, 0x7b, 0xbd, 0x2d, 0x74, 0xd0, 0x12, 0xb8, 0xe5, 0xb4, 0xb0, 0x89, 0x69, 0x97, 0x4a, 0x0c, 0x96, 0x77,
			0x7e, 0x65, 0xb9, 0xf1, 0x09, 0xc5, 0x6e, 0xc6, 0x84, 0x18, 0xf0, 0x7d, 0xec, 0x3a, 0xdc, 0x4d, 0x20, 0x79,
			0xee, 0x5f, 0x3e, 0xd7, 0xcb, 0x39, 0x48 };

	private int[] CK = { 0x00070e15, 0x1c232a31, 0x383f464d, 0x545b6269, 0x70777e85, 0x8c939aa1, 0xa8afb6bd, 0xc4cbd2d9,
			0xe0e7eef5, 0xfc030a11, 0x181f262d, 0x343b4249, 0x50575e65, 0x6c737a81, 0x888f969d, 0xa4abb2b9, 0xc0c7ced5,
			0xdce3eaf1, 0xf8ff060d, 0x141b2229, 0x30373e45, 0x4c535a61, 0x686f767d, 0x848b9299, 0xa0a7aeb5, 0xbcc3cad1,
			0xd8dfe6ed, 0xf4fb0209, 0x10171e25, 0x2c333a41, 0x484f565d, 0x646b7279 };

	/**
	 * 16 ���ƴ�ת�ֽ�����
	 */
//	public static final hexToArray(String str) {
//	  byte[] arr = []
//	  for (int i = 0, len = str.length; i < len; i += 2) {
//		  arr[i] = 
//	    arr.push(parseInt(str.substr(i, 2), 16))
//	  }
//	  return arr;
//	}

	/**
	 * �ֽ�����ת 16 ���ƴ�
	 */
//	function ArrayToHex(arr) {
//	  return arr.map(item => {
//	    item = item.toString(16)
//	    return item.length === 1 ? '0' + item : item
//	  }).join('')
//	}

	/**
	 * utf8 ��ת�ֽ�����
	 */
//	function utf8ToArray(str) {
//	  const arr = []
//
//	  for (let i = 0, len = str.length; i < len; i++) {
//	    const point = str.charCodeAt(i)
//
//	    if (point <= 0x007f) {
//	      // ���ӽڣ�����ֵ��00000000 00000000 0zzzzzzz
//	      arr.push(point)
//	    } else if (point <= 0x07ff) {
//	      // ˫�ֽڣ�����ֵ��00000000 00000yyy yyzzzzzz
//	      arr.push(0xc0 | (point >>> 6)) // 110yyyyy��0xc0-0xdf��
//	      arr.push(0x80 | (point & 0x3f)) // 10zzzzzz��0x80-0xbf��
//	    } else {
//	      // ���ֽڣ�����ֵ��00000000 xxxxyyyy yyzzzzzz
//	      arr.push(0xe0 | (point >>> 12)) // 1110xxxx��0xe0-0xef��
//	      arr.push(0x80 | ((point >>> 6) & 0x3f)) // 10yyyyyy��0x80-0xbf��
//	      arr.push(0x80 | (point & 0x3f)) // 10zzzzzz��0x80-0xbf��
//	    }
//	  }
//
//	  return arr
//	}

	/**
	 * �ֽ�����ת utf8 ��
	 */
//	function arrayToUtf8(arr) {
//	  const str = []
//	  for (let i = 0, len = arr.length; i < len; i++) {
//	    if (arr[i] >= 0xe0 && arr[i] <= 0xef) {
//	      // ���ֽ�
//	      str.push(String.fromCharCode(((arr[i] & 0x0f) << 12) + ((arr[i + 1] & 0x3f) << 6) + (arr[i + 2] & 0x3f)))
//	      i += 2
//	    } else if (arr[i] >= 0xc0 && arr[i] <= 0xdf) {
//	      // ˫�ֽ�
//	      str.push(String.fromCharCode(((arr[i] & 0x1f) << 6) + (arr[i + 1] & 0x3f)))
//	      i++
//	    } else {
//	      // ���ֽ�
//	      str.push(String.fromCharCode(arr[i]))
//	    }
//	  }
//
//	  return str.join('')
//	}

	/**
	 * 32 ����ѭ������
	 */
	private int rotl(int x, int y) {
		return x << y | x >>> (32 - y);
	}

	/**
	 * �����Ա任
	 */
	private int byteSub(int a) {
		return (Sbox[a >>> 24 & 0xFF] & 0xFF) << 24 | (Sbox[a >>> 16 & 0xFF] & 0xFF) << 16
				| (Sbox[a >>> 8 & 0xFF] & 0xFF) << 8 | (Sbox[a & 0xFF] & 0xFF);
	}

	/**
	 * ���Ա任������/������
	 */
	public int l1(int b) {
		return b ^ rotl(b, 2) ^ rotl(b, 10) ^ rotl(b, 18) ^ rotl(b, 24);
	}

	/**
	 * ���Ա任����������Կ��
	 */
	public int l2(int b) {
		return b ^ rotl(b, 13) ^ rotl(b, 23);
	}

	/**
	 * ��һ�� 128 ���ؽ��м���/���ܲ���
	 */
	public void sms4Crypt(byte[] input, byte[] output, int[] roundKey) {
		int[] x = new int[4];

		// �ֽ�����ת�������飨�˴� 1 �� = 32 ���أ�
		int[] tmp = new int[4];
		for (int i = 0; i < 4; i++) {
			tmp[0] = input[0 + 4 * i] & 0xff;
			tmp[1] = input[1 + 4 * i] & 0xff;
			tmp[2] = input[2 + 4 * i] & 0xff;
			tmp[3] = input[3 + 4 * i] & 0xff;
			x[i] = tmp[0] << 24 | tmp[1] << 16 | tmp[2] << 8 | tmp[3];
		}

		for (int r = 0, mid; r < 32; r += 4) {
			mid = x[1] ^ x[2] ^ x[3] ^ roundKey[r + 0];
			x[0] ^= l1(byteSub(mid)); // x[4]

			mid = x[2] ^ x[3] ^ x[0] ^ roundKey[r + 1];
			x[1] ^= l1(byteSub(mid)); // x[5]

			mid = x[3] ^ x[0] ^ x[1] ^ roundKey[r + 2];
			x[2] ^= l1(byteSub(mid)); // x[6]

			mid = x[0] ^ x[1] ^ x[2] ^ roundKey[r + 3];
			x[3] ^= l1(byteSub(mid)); // x[7]
		}

		// ����任
		for (int j = 0; j < 16; j += 4) {
			output[j] = (byte) (x[3 - j / 4] >>> 24 & 0xff);
			output[j + 1] = (byte) (x[3 - j / 4] >>> 16 & 0xff);
			output[j + 2] = (byte) (x[3 - j / 4] >>> 8 & 0xff);
			output[j + 3] = (byte) (x[3 - j / 4] & 0xff);
		}
	}

	/**
	 * ��Կ��չ�㷨
	 */
	public void sms4KeyExt(byte[] key, int[] roundKey, int cryptFlag) {
		int[] x = new int[4];

		// �ֽ�����ת�������飨�˴� 1 �� = 32 ���أ�
		int[] tmp = new int[4];
		for (int i = 0; i < 4; i++) {
			tmp[0] = key[0 + 4 * i] & 0xff;
			tmp[1] = key[1 + 4 * i] & 0xff;
			tmp[2] = key[2 + 4 * i] & 0xff;
			tmp[3] = key[3 + 4 * i] & 0xff;
			x[i] = tmp[0] << 24 | tmp[1] << 16 | tmp[2] << 8 | tmp[3];
		}

		// ��ϵͳ���������
		x[0] ^= 0xa3b1bac6;
		x[1] ^= 0x56aa3350;
		x[2] ^= 0x677d9197;
		x[3] ^= 0xb27022dc;

		for (int r = 0, mid; r < 32; r += 4) {
			mid = x[1] ^ x[2] ^ x[3] ^ CK[r + 0];
			roundKey[r + 0] = x[0] ^= l2(byteSub(mid)); // x[4]

			mid = x[2] ^ x[3] ^ x[0] ^ CK[r + 1];
			roundKey[r + 1] = x[1] ^= l2(byteSub(mid)); // x[5]

			mid = x[3] ^ x[0] ^ x[1] ^ CK[r + 2];
			roundKey[r + 2] = x[2] ^= l2(byteSub(mid)); // x[6]

			mid = x[0] ^ x[1] ^ x[2] ^ CK[r + 3];
			roundKey[r + 3] = x[3] ^= l2(byteSub(mid)); // x[7]
		}

		// ����ʱʹ�÷��������Կ
		if (cryptFlag == DECRYPT) {
			for (int r = 0, mid; r < 16; r++) {
				mid = roundKey[r];
				roundKey[r] = roundKey[31 - r];
				roundKey[31 - r] = mid;
			}
		}
	}

//	public String sm4(byte[] inArray, byte[] key, int cryptFlag, {padding = 'pkcs#5', mode) {
	public String sm4(byte[] inArray, byte[] key, int cryptFlag, String mode) {
		if ("CBC".equals(mode)) {
			// @TODO��CBC ģʽ��Ĭ���� ECB ģʽ
			return "";
		}

		// ��� key
//	  if (typeof key == 'string') {
//		  key = hexToArray(key);
//	  }
//	  if (key.length != (128 / 8)) {
//	    // key ���� 128 ����
//	    return "key is invalid";F
//	  }
//
//	  // �������
//	  if (typeof inArray === 'string') {
//	    if (cryptFlag != DECRYPT) {
//	      // ���ܣ�����Ϊ utf8 ��
//	      inArray = utf8ToArray(inArray)
//	    } else {
//	      // ���ܣ�����Ϊ 16 ���ƴ�
//	      inArray = hexToArray(inArray)
//	    }
//	  } else {
//	    inArray = [...inArray];
//	  }

		// �������
//	  if (padding === 'pkcs#5' && cryptFlag !== DECRYPT) {
		if (cryptFlag != DECRYPT) {
			int paddingCount = BLOCK - inArray.length % BLOCK;
			for (int i = 0; i < paddingCount; i++) {
//	    	inArray[i] = paddingCount;
			}
		}

		// ��������Կ
		int[] roundKey = new int[ROUND];
		sms4KeyExt(key, roundKey, cryptFlag);

		byte[] outArray = {};
		int restLen = inArray.length;
		int point = 0;
		while (restLen >= BLOCK) {
			byte[] input = Arrays.copyOfRange(inArray, point, point + 16);
			byte[] output = new byte[16];
			sms4Crypt(input, output, roundKey);
			for (int i = 0; i < BLOCK; i++) {
				outArray[point + i] = output[i];
			}
			restLen -= BLOCK;
			point += BLOCK;
		}

		// ȥ�����
//	  if (padding === 'pkcs#5' && cryptFlag === DECRYPT) {
//	    const paddingCount = outArray[outArray.length - 1]
//	    outArray.splice(outArray.length - paddingCount, paddingCount)
//	  }

		// �������
//	  if (output !== 'array') {
//	    if (cryptFlag !== DECRYPT) {
//	      // ���ܣ����ת 16 ���ƴ�
//	      return ArrayToHex(outArray);
//	    } else {
//	      // ���ܣ����ת utf8 ��
//	      return arrayToUtf8(outArray);
//	    }
//	  } else {
		return new String(outArray);
//	  }
	}

//	module.exports = {
//	  encrypt(inArray, key, options) {
//	    return sm4(inArray, key, 1, options)
//	  },
//	  decrypt(inArray, key, options) {
//	    return sm4(inArray, key, 0, options)
//	  }
//	}

	public static void main(String[] args) {
		SM4 sm4 = new SM4();
		byte[] inArray = "41dae73a9c7f298730234af92df53cff".getBytes();
		byte[] key = "41DAE73A9C7F298730234AF92DF53CFF".getBytes();
		String decodePin = sm4.sm4(inArray, key, 0, "");
		System.out.println(decodePin);
	}
}
