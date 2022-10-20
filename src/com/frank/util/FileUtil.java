package com.frank.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * �ļ�������
 * 
 * @author kst 20190922
 * @since https://www.cnblogs.com/xiaokw/p/12630952.html
 *        https://blog.csdn.net/q42368773/article/details/103796774
 */
public class FileUtil {
	/**
	 * �ļ�����
	 * 
	 * @param srcFile    Դ�ļ�
	 * @param targetFile Ŀ���ļ�
	 * @author kst,2019-09-22
	 */
	public static void copyFile(String srcFile, String destFile) {
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(new File(srcFile)));
			OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(destFile)));
			byte[] b = new byte[1024];
			int len;
			while ((len = is.read(b)) != -1) {
				os.write(b, 0, len);
			}
			os.flush();
			os.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void convertHtmlToPdf(String srcHtmlPath, String destPdfPath) throws Exception {
//		try {
//			Document document = new Document(PageSize.LETTER);
//			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destFilePath));
//			document.open();
//			document.addAuthor("test");
//			document.addCreator("test");
//			document.addSubject("test");
//			document.addCreationDate();
//			document.addTitle("XHTML to PDF");
//
//			XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
//			worker.parseXHtml(pdfWriter, document, new FileInputStream(srcHtmlPath), null, new AsianFontProvider());
//			document.close();
//			System.out.println("Done.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		// step 1
		Document document = new Document();
		// step 2
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(destPdfPath));
		// step 3
		document.open();
		// step 4
		XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(srcHtmlPath));
		// step 5
		document.close();
		System.out.println("PDF Created!");
	}

	/**
	 * �ַ���д��txt�ļ���ȥ
	 * 
	 * @param excelStr    excel�ַ���
	 * @param txtFilePath txt����·��
	 * @return �Ƿ�ɹ�
	 * @author kst,20220215
	 */
	public static String writeToTxt(String excelStr, String txtFilePath) {
		try {
			String[] str = excelStr.split("\r\n");
			PrintStream ps = new PrintStream(new FileOutputStream(new File(txtFilePath)));
			for (int i = 0; i < str.length; i++) {
				ps.println(str[i]);
			}
			ps.flush();
			ps.close();
			return "success";
		} catch (Exception e) {
			System.out.println("дtxt�ļ�����:" + e.getMessage());
			return "fail";
		}
	}

	private static final String PDF_PATH = "E:\\testFile\\html2PDF.pdf";
	private static final String HTML_PATH = "E:\\testFile\\pdfTest.jsp";
	private static final String CSS_PATH = "E:\\testFile\\html2pdf.css";

	public static void ss(String[] args) throws Exception {
//		BaseFont baseFont = BaseFont.createFont("E:\\testFile\\msyh.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		// �������Ҫ�Ӵ֣��޸ĵ���������
//		Font msya = new Font(baseFont, 12, Font.NORMAL);

		Document document = new Document(PageSize.A4, 10, 10, 10, 10);// �������µ�margin
		document.setMargins(0, 0, 0, 0);
		PdfWriter pdfwriter;
		pdfwriter = PdfWriter.getInstance(document, new FileOutputStream(PDF_PATH));
		document.open();
		XMLWorkerHelper wh = XMLWorkerHelper.getInstance();
		InputStream cssInput = new FileInputStream(CSS_PATH);
		wh.parseXHtml(pdfwriter, document, new FileInputStream(HTML_PATH), cssInput, new AsianFontProvider());

		/*
		 * // ��ȡ�� html �����ݺ󣬿��Լ����� pdf �ļ���д�������� // ��ȡһ��ͼƬ Image image =
		 * Image.getInstance("E:\\testFile\\dream.jpg");
		 * 
		 * image.scalePercent(50); image.setAlignment(Image.ALIGN_RIGHT); // ����ͼƬ�ľ���λ��
		 * // image.setAbsolutePosition(0, 0); // image.scaleAbsolute(500, 400); //
		 * ����һ��ͼƬ document.add(image); document.add(new Phrase("�������", msya)); //
		 * document.add(new Paragraph("\n")); document.add(new Paragraph("��������", msya));
		 */
		document.close();

		System.out.println("succeed");
	}

	public static void main(String[] args) throws Exception {
		// 1.�����ļ�
//		String srcFile = "C:/kang/image/demo.txt";
//		String destFile = "C:/kang/image/demo_fb.txt";
//		copyFile(srcFile, destFile);

		// 2.�����ļ�
		// txt
//		File srcFile = new File("C:/kang/image/demo.txt");
//		File destFile = new File("C:/kang/image/demo_fb.txt");
		// pdf
//		File srcFile = new File("C:/kang/image/sunhuai.pdf");
//		File destFile = new File("C:/kang/image/sunhuai_fb.pdf");
		// png
//		File srcFile = new File("C:/kang/image/2.png");
//		File destFile = new File("C:/kang/image/2_fb.png");
		// jpg
//		File srcFile = new File("C:/kang/image/17.jpg");
//		File destFile = new File("C:/kang/image/17_fb.jpg");
//		FileUtils.copyFile(srcFile, destFile);

		// 3.commons.io�����ļ���Ŀ¼
//		File srcFile = new File("C:/kang/image/demo.txt");
//		File destDir = new File("C:/kang/image/demo/");
//		FileUtils.copyFileToDirectory(srcFile, destDir);

		// 4.commons.io����Ŀ¼
//		File srcDir = new File("C:/kang/image/demo/");
//		File destDir = new File("C:/kang/image/test");
		// ԴĿ¼��Ŀ¼Ŀ¼���ļ����Ƶ�Ŀ��Ŀ¼��ͷ
//		FileUtils.copyDirectory(srcDir, destDir);
		// ԴĿ¼���Ƶ�Ŀ��Ŀ¼��ͷ(��ԴĿ¼)
//		FileUtils.copyDirectoryToDirectory(srcDir, destDir);

		// 5.commons.io����URL�������ļ�
//		URL url = new URL("http://www.baidu.com");
//		File destination = new File("C:/kang/image/baidu.html");
//		FileUtils.copyURLToFile(url, destination);

		// 6.commons.io����URL�������ַ���
//		URL url = new URL("http://www.baidu.com");
//		String urlStr = IOUtils.toString(url, "UTF-8");
//		System.out.println(urlStr);

		// 7.commons.io��ȡ�ļ�
		File file = new File("C:/kang/image/test.txt");
//		List<String> lineList = FileUtils.readLines(file, Charset.defaultCharset());
//		System.out.println(lineList);
		// ��ȡ�ļ�����
//		String lineStr = FileUtils.readFileToString(file, Charset.defaultCharset());
		String lineStr = FileUtils.readFileToString(file, "utf-8");
		System.out.println(lineStr);

		// 8.tika��ȡ�ļ�
//		File file = new File("C:/kang/image/demo.txt");
//		Tika tika = new Tika();
//		String fileContent = tika.parseToString(file);
//		System.out.println(fileContent);

		// 9.commons.ioд���ļ�:�ļ�����
//		File srcFile = new File("C:/kang/image/demo.txt");
//		File destFile = new File("C:/kang/image/demo_fb.txt");
//		List<String> lineList = FileUtils.readLines(srcFile, Charset.defaultCharset());
//		FileUtils.writeLines(destFile, lineList);

//		// 10.commons.ioд���ļ�:�ļ�������
//		File srcFile = new File("C:/kang/image/demo.txt");
//		File destFile = new File("C:/kang/image/demo_fb.txt");
//		// ������
//		InputStream is = new BufferedInputStream(new FileInputStream(srcFile));
//		// �����ж�ȡ���ݣ�תΪlist
//		List<String> lineList = IOUtils.readLines(is, Charset.defaultCharset());
//		FileUtils.writeLines(destFile, lineList);

		// 11.commons.ioд���ļ�:�ַ���
//		File destFile = new File("C:/kang/image/demo_fb.txt");
//		List<String> lineList = Lists.newArrayList("�й�", "�ձ�", "����˹", "����");
		// listװ�ַ���
//		FileUtils.writeLines(destFile, lineList);
		// ֱ���ַ���
//		FileUtils.writeStringToFile(destFile, "�����й���\n֧����֧��", Charset.defaultCharset());

		// 12.commons.ioɾ��Ŀ¼(��Ŀ¼���ļ�����Ŀ¼)
//		File srcFile = new File("C:/kang/image/demo/");
//		FileUtils.deleteDirectory(srcFile);

		// 13.commons.ioɾ��Ŀ¼���ļ�
//		File deleteFile = new File("C:/kang/image/demo_fb.txt");
//		File deleteDir = new File("C:/kang/image/demo/");
//		FileUtils.forceDelete(deleteFile);

		// 14.commons.io�����ļ���С:byteΪ��λ
//		File srcFile = new File("C:/kang/image/demo.txt");
//		long size = FileUtils.sizeOf(srcFile);
//		System.out.println(size + "byte");

		// 15.commons.io����Ŀ¼��С:byteΪ��λ
//		File srcDir = new File("C:\\kang\\image\\opencv");
//		long size = FileUtils.sizeOf(srcDir);
//		System.out.println(size + "byte");

		// 16.�ļ�������
//		File srcFile = new File("C:/kang/image/demo_fb.txt");
//		File destFile = new File("C:/kang/image/demo_rename.txt");
//		boolean flag = srcFile.renameTo(destFile);
//		System.out.println(flag);

		// 17.commons.io��FilenameUtils��ʹ��
		// (1)�ϲ�Ŀ¼���ļ���Ϊ�ļ�ȫ·��
//		String basePath = "C:/kang/image/demo/";
//		String fullFilenameToAdd = "C:/kang/image/demo/demo.txt";
//		String fullFilenameToAdd = "demo.txt";
//		String concatPath = FilenameUtils.concat(basePath, fullFilenameToAdd);
//		System.out.println(concatPath);

		// (2)ȥ��Ŀ¼�ͺ�׺����ļ���
//		String filename = "C:/kang/image/demo/demo.txt";
//		String baseName = FilenameUtils.getBaseName(filename);
//		System.out.println(baseName);

		// (3)��ȡ�ļ��ĺ�׺
//		String filename = "C:/kang/image/demo/demo.txt";
//		String extension = FilenameUtils.getExtension(filename);
//		System.out.println(extension);

		// (4)��ȡ�ļ���Ŀ¼
//		String filename = "C:/kang/image/demo/demo.txt";
//		String fullPath = FilenameUtils.getFullPath(filename);
//		System.out.println(fullPath);

		// (5)��ȡ�ļ���
//		String filename = "C:/kang/image/demo/demo.txt";
//		String name = FilenameUtils.getName(filename);
//		System.out.println(name);

		// (6)ȥ���̷����·��
//		String filename = "C:/kang/image/demo/demo.txt";
//		String path = FilenameUtils.getPath(filename);
//		System.out.println(path);

		// (7)�̷�
//		String filename = "C:/kang/image/demo/demo.txt";
//		String prefix = FilenameUtils.getPrefix(filename);
//		System.out.println(prefix);

		// (8)��ȡ���һ��.��λ��
//		String filename = "C:/kang/image/demo/demo.txt";
//		int indexOfExtension = FilenameUtils.indexOfExtension(filename);
//		System.out.println(indexOfExtension);

		// (9)��ȡ���һ��/��λ��
//		String filename = "C:/kang/image/demo/demo.txt";
//		int indexOfLastSeparator = FilenameUtils.indexOfLastSeparator(filename);
//		System.out.println(indexOfLastSeparator);

		// (10)��ȡ��ǰϵͳ��ʽ��·��
//		String filename = "C:/kang/image/demo/demo.txt";
//		String normalizeName = FilenameUtils.normalize(filename);
//		System.out.println(normalizeName);

		// (11)�Ƴ��ļ�����չ��
//		String filename = "C:/kang/image/demo/demo.txt";
//		String removeExtensionName = FilenameUtils.removeExtension(filename);
//		System.out.println(removeExtensionName);

		// (12)ת���ָ���Ϊ��ǰϵͳ�ָ���
//		String path = "C:/kang/image/demo/demo.txt";
//		String name = FilenameUtils.separatorsToSystem(path);
//		System.out.println(name);

		// (13)ת���ָ���Ϊlinuxϵͳ�ָ���
//		String path = "C:/kang/image/demo/demo.txt";
//		String linuxPath = FilenameUtils.separatorsToUnix(path);
//		System.out.println(linuxPath);

		// (14)ת���ָ���Ϊwindowsϵͳ�ָ���
//		String path = "C:/kang/image/demo/demo.txt";
//		String windowsPath = FilenameUtils.separatorsToWindows(path);
//		System.out.println(windowsPath);

		// (15)�ж��ļ�·���Ƿ���ͬ���Ǹ�ʽ��
//		String filename1 = "C:/kang/image/demo/demo.txt";
//		String filename2 = "C:/kang/image/demo/demo_fb.txt";
//		String filename2 = "C:/kang/image/demo/demo.txt";
//		boolean flag = FilenameUtils.equals(filename1, filename2);
//		System.out.println(flag);

		// (16)�ж��ļ�·���Ƿ���ͬ����ʽ��
//		String filename1 = "C:/kang/image/demo/demo.txt";
//		String filename2 = "C:/kang/image/demo/demo_fb.txt";
//		String filename2 = "C:\\kang\\image\\demo\\demo.txt";
//		boolean flag = FilenameUtils.equalsNormalized(filename1, filename2);
//		System.out.println(flag);

		// (17)�ж�Ŀ¼���Ƿ����ָ���ļ���Ŀ¼
//		String canonicalParent = "C:/kang/image/demo/";
//		String canonicalChild = "C:/kang/image/demo/demo.txt";
//		boolean flag = FilenameUtils.directoryContains(canonicalParent, canonicalChild);
//		System.out.println(flag);

		// (18)�ж��ļ���չ���Ƿ������ָ������(���顢�ַ���)��
//		String filename = "C:/kang/image/demo/demo.txt";
//		String extension = "txt";
//		String extension = "pdf";
//		boolean flag = FilenameUtils.isExtension(filename, extension);
//		System.out.println(flag);

		// (19)�ж��ļ���չ���Ƿ��ָ������ƥ��
//		String filename = "C:/kang/image/demo/demo.txt";
//		String wildcardMatcher = "*.txt";
//		boolean flag = FilenameUtils.wildcardMatch(filename, wildcardMatcher);
//		System.out.println(flag);

		// 18.
//		String srcHtmlPath = "C:/kang/image/tradeDetail1.html";
//		String destPdfPath = "C:/kang/image/tradeDetail1_fb.pdf";
//		convertHtmlToPdf(srcHtmlPath, destPdfPath);
	}

}
