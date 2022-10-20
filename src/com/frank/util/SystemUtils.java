package com.frank.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Set;

/**
 * 测试System属性
 * 
 * @author kst
 * @date 2018-12-02 15:07:08
 */
public class SystemUtils {

	public static void main(String[] args) throws Exception {
        getSystemInfos();
	}

	/**
	 * 获取系统相关信息
	 */
	public static void getSystemInfos() throws Exception {
		// 通过StringBuilder来构建要输出的内容
		StringBuilder sb = new StringBuilder();
		sb.append("Java运行时环境版本:" + System.getProperty("java.version") + "\n");
		sb.append("Java运行时环境供应商:" + System.getProperty("java.vendor") + "\n");
		sb.append("Java供应商的URL:" + System.getProperty("java.vendor.url") + "\n");
		sb.append("Java安装目录:" + System.getProperty("java.home") + "\n");
		sb.append("Java虚拟机规范版本:" + System.getProperty("java.vm.specification.version") + "\n");
		sb.append("Java类格式版本号:" + System.getProperty("java.class.version") + "\n");
		sb.append("Java类路径：" + System.getProperty("java.class.path") + "\n");
		sb.append("加载库时搜索的路径列表:" + System.getProperty("java.library.path") + "\n");
		sb.append("默认的临时文件路径:" + System.getProperty("java.io.tmpdir") + "\n");
		sb.append("要使用的 JIT编译器的名称:" + System.getProperty("java.compiler") + "\n");
		sb.append("一个或多个扩展目录的路径:" + System.getProperty("java.ext.dirs") + "\n");
		sb.append("操作系统的名称:" + System.getProperty("os.name") + "\n");
		sb.append("操作系统的架构:" + System.getProperty("os.arch") + "\n");
		sb.append("操作系统的版本:" + System.getProperty("os.version") + "\n");
		sb.append("文件分隔符（在 UNIX 系统中是“/”）:" + System.getProperty("file.separator") + "\n");
		sb.append("路径分隔符（在 UNIX 系统中是“:”）:" + System.getProperty("path.separator") + "\n");
		sb.append("行分隔符（在 UNIX 系统中是“/n”）:" + System.getProperty("line.separator") + "\n");
		sb.append("用户的账户名称:" + System.getProperty("user.name") + "\n");
		sb.append("用户的主目录:" + System.getProperty("user.home") + "\n");
		sb.append("用户的当前工作目录:" + System.getProperty("user.dir") + "\n");
		sb.append("Java临时目录:" + System.getProperty("java.io.tmpdir") + "\n");
		sb.append("主机ip:" + getHostIp(getInetAddress()) + "\n");
		sb.append("主机name:" + getHostName(getInetAddress()) + "\n");
		sb.append("----------------------------------------------------------------" + "\n");
		// 获取系统的属性
		Properties ps = System.getProperties();
		// 获得系统属性中的键值
		Set<String> set = ps.stringPropertyNames();
		for (String name : set) {
			sb.append(name + " : " + ps.getProperty(name) + "\n");
		}
		// 新建一个文件，如果该文件不存在则创建一个
		File file = new File("C:/kang/image/demo/t.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		OutputStream ous = new FileOutputStream(file);
		ous.write(sb.toString().getBytes());
		ous.close();
		System.out.println("生成文件成功。");
	}

	/**
	 * 获取本地主机
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
	 * 通过InetAddress获取本地Ip
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
	 * 通过InetAddress获取本地主机的名字
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
	 * 获取系统属性信息
	 */
	public static void getSystemProperties() {
		System.out.println(System.getProperties());
	}

	/**
	 * 获取系统环境信息
	 */
	public static void getSystemEnv() {
		System.out.println(System.getenv());
	}

	/**
	 * 删除temp目录冗余文件
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
