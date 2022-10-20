package com.frank.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Set;

/**
 * ����System����
 * 
 * @author kst
 * @date 2018-12-02 15:07:08
 */
public class SystemUtils {

	public static void main(String[] args) throws Exception {
        getSystemInfos();
	}

	/**
	 * ��ȡϵͳ�����Ϣ
	 */
	public static void getSystemInfos() throws Exception {
		// ͨ��StringBuilder������Ҫ���������
		StringBuilder sb = new StringBuilder();
		sb.append("Java����ʱ�����汾:" + System.getProperty("java.version") + "\n");
		sb.append("Java����ʱ������Ӧ��:" + System.getProperty("java.vendor") + "\n");
		sb.append("Java��Ӧ�̵�URL:" + System.getProperty("java.vendor.url") + "\n");
		sb.append("Java��װĿ¼:" + System.getProperty("java.home") + "\n");
		sb.append("Java������淶�汾:" + System.getProperty("java.vm.specification.version") + "\n");
		sb.append("Java���ʽ�汾��:" + System.getProperty("java.class.version") + "\n");
		sb.append("Java��·����" + System.getProperty("java.class.path") + "\n");
		sb.append("���ؿ�ʱ������·���б�:" + System.getProperty("java.library.path") + "\n");
		sb.append("Ĭ�ϵ���ʱ�ļ�·��:" + System.getProperty("java.io.tmpdir") + "\n");
		sb.append("Ҫʹ�õ� JIT������������:" + System.getProperty("java.compiler") + "\n");
		sb.append("һ��������չĿ¼��·��:" + System.getProperty("java.ext.dirs") + "\n");
		sb.append("����ϵͳ������:" + System.getProperty("os.name") + "\n");
		sb.append("����ϵͳ�ļܹ�:" + System.getProperty("os.arch") + "\n");
		sb.append("����ϵͳ�İ汾:" + System.getProperty("os.version") + "\n");
		sb.append("�ļ��ָ������� UNIX ϵͳ���ǡ�/����:" + System.getProperty("file.separator") + "\n");
		sb.append("·���ָ������� UNIX ϵͳ���ǡ�:����:" + System.getProperty("path.separator") + "\n");
		sb.append("�зָ������� UNIX ϵͳ���ǡ�/n����:" + System.getProperty("line.separator") + "\n");
		sb.append("�û����˻�����:" + System.getProperty("user.name") + "\n");
		sb.append("�û�����Ŀ¼:" + System.getProperty("user.home") + "\n");
		sb.append("�û��ĵ�ǰ����Ŀ¼:" + System.getProperty("user.dir") + "\n");
		sb.append("Java��ʱĿ¼:" + System.getProperty("java.io.tmpdir") + "\n");
		sb.append("����ip:" + getHostIp(getInetAddress()) + "\n");
		sb.append("����name:" + getHostName(getInetAddress()) + "\n");
		sb.append("----------------------------------------------------------------" + "\n");
		// ��ȡϵͳ������
		Properties ps = System.getProperties();
		// ���ϵͳ�����еļ�ֵ
		Set<String> set = ps.stringPropertyNames();
		for (String name : set) {
			sb.append(name + " : " + ps.getProperty(name) + "\n");
		}
		// �½�һ���ļ���������ļ��������򴴽�һ��
		File file = new File("C:/kang/image/demo/t.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		OutputStream ous = new FileOutputStream(file);
		ous.write(sb.toString().getBytes());
		ous.close();
		System.out.println("�����ļ��ɹ���");
	}

	/**
	 * ��ȡ��������
	 * 
	 * @return
	 */
	public static InetAddress getInetAddress() {
		try {
			return InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			System.out.println("unknown host!");
		}
		return null;
	}

	/**
	 * ͨ��InetAddress��ȡ����Ip
	 * 
	 * @param netAddress
	 * @return
	 */
	public static String getHostIp(InetAddress netAddress) {
		if (null == netAddress) {
			return null;
		}
		String ip = netAddress.getHostAddress();
		return ip;
	}

	/**
	 * ͨ��InetAddress��ȡ��������������
	 * 
	 * @param netAddress
	 * @return
	 */
	public static String getHostName(InetAddress netAddress) {
		if (null == netAddress) {
			return null;
		}
		String name = netAddress.getHostName();
		return name;
	}

	/**
	 * ��ȡϵͳ������Ϣ
	 */
	public static void getSystemProperties() {
		System.out.println(System.getProperties());
	}

	/**
	 * ��ȡϵͳ������Ϣ
	 */
	public static void getSystemEnv() {
		System.out.println(System.getenv());
	}

	/**
	 * ɾ��tempĿ¼�����ļ�
	 */
	public static void deleteTempFilterFile() {
		String tempPath = System.getProperty("java.io.tmpdir");
		System.out.println(tempPath);

//		if (tempPath.contains("ADMINI~1")) {
//			tempPath = tempPath.replace("ADMINI~1", "Administrator");
//		}

		File dir = new File(tempPath);
		for (File file : dir.listFiles()) {
			if (!file.isDirectory() && file.getName().startsWith("e4j")) {
				file.delete();
			}
		}
	}
}
