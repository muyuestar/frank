package com.frank.util;

/**
 * @author kst
 * @date 2019年12月2日 上午9:39:01
 * 
 */
public class ByteUtil {
	private static final String HEX_PREFIX = "0x";

	public static byte[] toDBCS(byte[] data) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < data.length; ++i) {
			String hex = Integer.toHexString(data[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			builder.append(hex.toUpperCase());
		}
		return builder.toString().getBytes();
	}

	public static byte[] toSBCS(byte[] data) {
		byte[] result = new byte[data.length / 2];
		for (int i = 0; i < result.length; ++i) {
			result[i] = uniteBytes(data[(i * 2)], data[(i * 2 + 1)]);
		}
		return result;
	}

	private static byte uniteBytes(byte srcByte1, byte srcByte2) {
		byte b1 = Byte.decode("0x" + new String(new byte[] { srcByte1 })).byteValue();
		b1 = (byte) (b1 << 4);
		byte b2 = Byte.decode("0x" + new String(new byte[] { srcByte2 })).byteValue();
		return (byte) (b1 ^ b2);
	}
}
