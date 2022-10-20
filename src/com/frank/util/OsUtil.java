package com.frank.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

/**
 * 操作系统相关方法
 * 
 * @author kst
 * @date 2019-03-14 15:44:29
 */
public class OsUtil {
	/**
	 * 查看指定的端口号是否空闲，若空闲则返回否则返回一个随机的空闲端口号
	 */
	public static int getFreePort(int defaultPort) throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(defaultPort)) {
			return serverSocket.getLocalPort();
		} catch (IOException e) {
			return getFreePort();
		}
	}

	/**
	 * 获取空闲端口号
	 */
	public static int getFreePort() throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(0)) {
			return serverSocket.getLocalPort();
		}
	}

	/**
	 * 检查端口号是否被占用
	 */
	public static boolean isBusyPort(int port) {
		boolean ret = true;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			ret = false;
		} catch (Exception e) {
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	private static final String OS = System.getProperty("os.name").toLowerCase();

	public static boolean isWindows() {
		return OS.indexOf("win") >= 0;
	}

	public static boolean isWindowsXP() {
		return OS.indexOf("win") >= 0 && OS.indexOf("xp") >= 0;
	}

	public static boolean isMac() {
		return OS.indexOf("mac") >= 0;
	}

	public static boolean isUnix() {
		return OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") >= 0;
	}

	public static boolean isSolaris() {
		return (OS.indexOf("sunos") >= 0);
	}

	private static final String ARCH = System.getProperty("sun.arch.data.model");

	public static boolean is64() {
		return "64".equals(ARCH);
	}

	public static boolean is32() {
		return "32".equals(ARCH);
	}

	/**
	 * 获取CPU核数 N = CPU核数 * CPU利用率 * (1 + W/C) W=等待时间，C=计算时间
	 * 
	 * @return 核数
	 * @author kst 20210622
	 */
	public static int getCpuKernel() {
		return Runtime.getRuntime().availableProcessors();
	}

	/**
	 * 获取空闲内存
	 * 
	 * @return Java虚拟机空闲内存
	 * @author kst 20210628
	 */
	public static long getFreeMemory() {
		return Runtime.getRuntime().freeMemory();
	}

	/**
	 * 获取总内存
	 * 
	 * @return Java虚拟机总内存
	 * @author kst 20210628
	 */
	public static long getTotalMemory() {
		return Runtime.getRuntime().totalMemory();
	}

	/**
	 * 获取最大内存
	 * 
	 * @return Java虚拟机最大内存
	 * @author kst 20210628
	 */
	public static long getMaxMemory() {
		return Runtime.getRuntime().maxMemory();
	}

	public static void copyFile(String cmdStr) throws Exception {
		String str = "";
		String[] cmd = new String[] { "cmd", "/C", cmdStr };
		Process proc = Runtime.getRuntime().exec(cmd);
		BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		proc.waitFor();
	}

	public static void main(String[] args) throws Exception {
//		System.out.println(getTotalMemory());
//		System.out.println(getMaxMemory());

//		copyFile("copy C:\\kang\\image\\1.txt C:\\kang\\image\\2.txt");
	}
}
