package com.frank.util;

import java.io.File;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author kst
 * @date 2019-03-14 16:54:15
 */
public class PathUtil {
	public static String ROOT_PATH;

	static {
		URL url = PathUtil.class.getResource("/");
		ROOT_PATH = url.getPath();
		try {
			URLConnection connection = url.openConnection();
			if (connection instanceof JarURLConnection) {
				File userDir = new File(System.getProperty("user.dir"));
				File classPathDir = new File(System.getProperty("java.class.path")).getAbsoluteFile().getParentFile();
				ROOT_PATH = userDir.getAbsolutePath().length() > classPathDir.getAbsolutePath().length()
						? userDir.getAbsolutePath() : classPathDir.getAbsolutePath();
			}
		} catch (Exception e) {
		}
		if (OsUtil.isWindows() && ROOT_PATH.matches("^/.*$")) {
			ROOT_PATH = ROOT_PATH.substring(1);
		}
		if (ROOT_PATH.matches("^.*[\\\\/]$")) {
			ROOT_PATH = ROOT_PATH.substring(0, ROOT_PATH.length() - 1);
		}
	}
}
