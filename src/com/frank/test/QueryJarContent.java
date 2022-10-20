package com.frank.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 查看jar包里某行内容
 * 
 * @author kst
 * @date 2022-05-17 21:19:50
 */
public class QueryJarContent {

	private static final String path = "C:/kang/tools/afawzwzh/workspace/functionModule/technologyComponent/projects/ECIP/VOU/dependencies/"; // jar包父目录
	private static final String keywords = "PDFSignature failed"; // 关键字

	public static void indesJar(String path, String keywords) {
		File file = new File(path);
		final Pattern p = Pattern.compile(".+\\.jar$");
		File[] files = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return p.matcher(pathname.getPath()).matches();
			}
		});
		search(files, keywords);
	}

	private static void search(File[] files, String keywords) {
		try {
			for (File f : files) {
				if (f.isDirectory()) {
					search(f.listFiles(), keywords);
				} else {
					ZipFile jar = new ZipFile(f);
					Enumeration enumration = jar.entries();
					while (enumration.hasMoreElements()) {
						ZipEntry zipEntry = (ZipEntry) enumration.nextElement();

						InputStreamReader isr = new InputStreamReader(jar.getInputStream(zipEntry));
						BufferedReader br = new BufferedReader(isr);
						String line = br.readLine();
						int line_num = 1;
						while (null != line) {
							if (line.contains(keywords)) {
								System.out.println(
										f.getPath() + "," + zipEntry.getName() + "," + "line number = " + line_num);
							}
							line = br.readLine();
							line_num++;
						}
					}
				}
			}
		} catch (IOException io_e) {
			io_e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		indesJar(path, keywords);
	}

}
