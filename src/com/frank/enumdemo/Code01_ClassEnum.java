package com.frank.enumdemo;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 *
 * @author kst
 * @date 2022-03-04 14:49:10
 */
public class Code01_ClassEnum {

	public static void main(String[] args) {
		String type = CipherType.SM.name();
		System.out.println(type);
	}

	/**
	 * ��ż��ܷ�ʽ��Ӧ����Ϣ,���ܷ�ʽ������ѡ��
	 * 
	 * @author chenpanyu
	 *
	 */
	public enum CipherType {
		/** ��������ͻ��˵�Ӧ����Ϣ����Ӧ������ */
		NO(new CipherFilterMessage("NO_CIPHER_MESSAGE")),
		/** ��������ͻ��˵�Ӧ����Ϣ����Ӧʹ��SSL */
		SSL(new CipherFilterMessage("SSL_CIPHER_MESSAGE")),
		/** ��������ͻ��˵�Ӧ����Ϣ����Ӧʹ�ù��� */
		SM(new CipherFilterMessage("SM_CIPHER_MESSAGE"));

		// ����˽�б���
		private CipherFilterMessage message;

		// ���캯����ö������ֻ��Ϊ˽��
		private CipherType(CipherFilterMessage message) {
			this.message = message;
		}

		public CipherFilterMessage getMessage() {
			return message;
		}

		@Override
		public String toString() {
			return message.toString();
		}
	}

	public static class CipherFilterMessage {
		private final String name;

		private CipherFilterMessage(String name) {
			this.name = name;
		}

		public String toString() {
			return name;
		}

		public ByteBuffer getByteBuffer() {
			try {
				return ByteBuffer.wrap(name.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
			}
			return null;
		}

		public static CipherFilterMessage build(ByteBuffer buf) {
			try {
				int len = buf.limit();
				byte[] redundanceBuf = buf.array();
				byte[] nameBytes = new byte[len];
				System.arraycopy(redundanceBuf, 0, nameBytes, 0, len);
				return new CipherFilterMessage(new String(nameBytes, "UTF-8").trim());
			} catch (UnsupportedEncodingException e) {
			}
			return null;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof CipherFilterMessage) {
				CipherFilterMessage sfm = (CipherFilterMessage) o;
				return (name == null) ? (o == name) : name.toString().equals(sfm.toString());
			}
			return false;
		}

		@Override
		public int hashCode() {
			return super.hashCode();
		}
	}

}
