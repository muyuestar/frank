package com.frank.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kst
 * @date 2019-03-29 11:05:53 �����ļ�����
 */
public class TestFileAttribute {

	public static void main(String[] args) throws IOException {
//		getAttribute("E:/kst/2003.xls");
//		geFileInfo("E:/kst/2003.xls");
		getAttribute1("E:/kst/2003.xls");
	}

	public static void getAttribute(String path) {
		File file = new File(path);
		System.out.println(
				"���һ�θ������ڣ�" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));
		System.out.printf("�ļ���С:%.3fKB", file.length() / 1024.0);// �ֽ�
	}

	public static void geFileInfo(String srcFile) throws IOException {
		Path path = Paths.get(srcFile);
		System.out.println(Files.isDirectory(path));
		System.out.println(Files.isExecutable(path));// �Ƿ��ǿ�ִ���ļ� true
		System.out.println(Files.isHidden(path));
		System.out.println(Files.isReadable(path));
		System.out.println(Files.isWritable(path));
		System.out.println(Files.isRegularFile(path));// �Ƿ��ǳ����ļ�
		System.out.println(Files.isSymbolicLink(path));// �Ƿ��Ƿ�������
		System.out.println(Files.size(path));//
		System.out.println("Ĭ�ϻ�ȡ��������ʱ����0����ʱ�䣺" + Files.getLastModifiedTime(path));// 2016-01-12T05:20:44.466277Z
		// ��ʽ��ʱ��
		Date date = new Date(Files.getLastModifiedTime(path).toMillis());
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		System.out.println("ʹ��Ĭ�ϵĶ�������ʽ����" + time);
		System.out.println(Files.getOwner(path));
	}

	public static void getAttribute1(String path) {
		Path filePath = Paths.get(path);
		try {
			BasicFileAttributes ra = Files.readAttributes(filePath, BasicFileAttributes.class);
			System.out.println("CREATION TIME:" + ra.creationTime());
			System.out.println("LAST ACCESS TIME:" + ra.lastAccessTime());
			System.out.println("FILE SIZE:" + ra.size());// �ֽ�
			System.out.println("LAST MODIFIED:" + ra.lastModifiedTime());
			System.out.println("IS SYSBOLIC LINK:" + ra.isSymbolicLink());
			System.out.println("IS FOLDER:" + ra.isDirectory());
			System.out.println("IS FILE:" + ra.isRegularFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void getAttribute2(String path) {
		Path fp = Paths.get(path);
		try {
			Files.getAttribute(fp, "basic:size");
			System.out.println("CREATION TIME:" + Files.getAttribute(fp, "basic:creationTime"));// ����ʱ��
			System.out.println("LAST ACCESS TIME:" + Files.getAttribute(fp, "basic:lastAccessTime"));// ����ʱ��
			System.out.println("FILE SIZE:" + Files.getAttribute(fp, "basic:size").toString());
			System.out.println("LAST MODIFIED:" + Files.getAttribute(fp, "basic:lastModifiedTime"));// �޸�ʱ��
			System.out.println("IS SYSBOLIC LINK:" + Files.getAttribute(fp, "basic:isSymbolicLink"));
			System.out.println("IS FOLDER:" + Files.getAttribute(fp, "basic:isDirectory"));
			System.out.println("IS FILE:" + Files.getAttribute(fp, "basic:isRegularFile"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void update1(String path) {
		Path fp = Paths.get(path);
		try {
			BasicFileAttributes ra = Files.readAttributes(fp, BasicFileAttributes.class);
			long currentTimeMillis = System.currentTimeMillis();
			FileTime fileTime = FileTime.fromMillis(currentTimeMillis);
			Files.setAttribute(fp, "basic:creationTime", fileTime);
			FileTime creationTime = (FileTime) Files.getAttribute(fp, "basic:creationTime");
			System.out.println("NEW CREATION TIME:" + creationTime.toString());
			System.out.println("OLD CREATION TIME:" + ra.creationTime());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void update2(String path) {
		Path fp = Paths.get("D:\\test.txt");
		try {
			BasicFileAttributes ra = Files.readAttributes(fp, BasicFileAttributes.class);
			long currentTimeMillis = System.currentTimeMillis();
			FileTime fileTime = FileTime.fromMillis(currentTimeMillis);
			// ֱ���޸��ļ��� �޸�ʱ��
			Files.setLastModifiedTime(fp, fileTime);
			// Files.setAttribute(path, attribute, value, options)
			FileTime time = (FileTime) Files.getAttribute(fp, "basic:lastModifiedTime");
			System.out.println("NEW LAST-MODIFIED-TIME:" + time.toString());
			System.out.println("OLD LAST-MODIFIED-TIME:" + ra.lastModifiedTime());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}