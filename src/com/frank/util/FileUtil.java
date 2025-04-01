package com.frank.util;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * 文件操作类
 *
 * @author kst 20190922
 * @since https://www.cnblogs.com/xiaokw/p/12630952.html
 * https://blog.csdn.net/q42368773/article/details/103796774
 */
public class FileUtil {
    /**
     * 文件复制
     *
     * @param srcFile    源文件
     * @param targetFile 目标文件
     * @author kst, 2019-09-22
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
     * 字符串写到txt文件中去
     *
     * @param excelStr    excel字符串
     * @param txtFilePath txt本地路径
     * @return 是否成功
     * @author kst, 20220215
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
            System.out.println("写txt文件错误:" + e.getMessage());
            return "fail";
        }
    }

    /**
     * 将文件转为base64
     *
     * @param file 文件名称
     * @return base64文件流
     * @throws IOException
     */
    public static String getBase64FromFile(File file) throws IOException {
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            int read = 0;
            byte[] buffer = new byte[1024];
            while ((read = in.read(buffer, 0, 1024)) != -1) {
                out.write(buffer, 0, read);
            }
            return Base64.getEncoder().encodeToString(out.toByteArray());
        } catch (IOException e) {
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // 1.复制文件
//		String srcFile = "C:/kang/image/demo.txt";
//		String destFile = "C:/kang/image/demo_fb.txt";
//		copyFile(srcFile, destFile);

        // 2.复制文件
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

        // 3.commons.io复制文件到目录
//		File srcFile = new File("C:/kang/image/demo.txt");
//		File destDir = new File("C:/kang/image/demo/");
//		FileUtils.copyFileToDirectory(srcFile, destDir);

        // 4.commons.io复制目录
//		File srcDir = new File("C:/kang/image/demo/");
//		File destDir = new File("C:/kang/image/test");
        // 源目录子目录目录、文件复制到目标目录里头
//		FileUtils.copyDirectory(srcDir, destDir);
        // 源目录复制到目标目录里头(含源目录)
//		FileUtils.copyDirectoryToDirectory(srcDir, destDir);

        // 5.commons.io复制URL内容至文件
//		URL url = new URL("http://www.baidu.com");
//		File destination = new File("C:/kang/image/baidu.html");
//		FileUtils.copyURLToFile(url, destination);

        // 6.commons.io复制URL内容至字符串
//		URL url = new URL("http://www.baidu.com");
//		String urlStr = IOUtils.toString(url, "UTF-8");
//		System.out.println(urlStr);

        // 7.commons.io读取文件
        File file = new File("C:/kang/image/test.txt");
        List<String> lineList = FileUtils.readLines(file, "utf-8");
        System.out.println(lineList);
        // 读取文件内容
//		String lineStr = FileUtils.readFileToString(file, Charset.defaultCharset());
//		String lineStr = FileUtils.readFileToString(file, "utf-8");
//		System.out.println(lineStr);

        // 8.tika读取文件
//		File file = new File("C:/kang/image/demo.txt");
//		Tika tika = new Tika();
//		String fileContent = tika.parseToString(file);
//		System.out.println(fileContent);

        // 9.commons.io写入文件:文件内容
//		File srcFile = new File("C:/kang/image/demo.txt");
//		File destFile = new File("C:/kang/image/demo_fb.txt");
//		List<String> lineList = FileUtils.readLines(srcFile, Charset.defaultCharset());
//		FileUtils.writeLines(destFile, lineList);

//		// 10.commons.io写入文件:文件流数据
//		File srcFile = new File("C:/kang/image/demo.txt");
//		File destFile = new File("C:/kang/image/demo_fb.txt");
//		// 拷贝流
//		InputStream is = new BufferedInputStream(new FileInputStream(srcFile));
//		// 从流中读取内容，转为list
//		List<String> lineList = IOUtils.readLines(is, Charset.defaultCharset());
//		FileUtils.writeLines(destFile, lineList);

        // 11.commons.io写入文件:字符串
//		File destFile = new File("C:/kang/image/demo_fb.txt");
//		List<String> lineList = Lists.newArrayList("中国", "日本", "俄罗斯", "美国");
        // list装字符串
//		FileUtils.writeLines(destFile, lineList);
        // 直接字符串
//		FileUtils.writeStringToFile(destFile, "我是中国人\n支付宝支付", Charset.defaultCharset());

        // 12.commons.io删除目录(含目录中文件、子目录)
//		File srcFile = new File("C:/kang/image/demo/");
//		FileUtils.deleteDirectory(srcFile);

        // 13.commons.io删除目录或文件
//		File deleteFile = new File("C:/kang/image/demo_fb.txt");
//		File deleteDir = new File("C:/kang/image/demo/");
//		FileUtils.forceDelete(deleteFile);

        // 14.commons.io计算文件大小:byte为单位
//		File srcFile = new File("C:/kang/image/demo.txt");
//		long size = FileUtils.sizeOf(srcFile);
//		System.out.println(size + "byte");

        // 15.commons.io计算目录大小:byte为单位
//		File srcDir = new File("C:\\kang\\image\\opencv");
//		long size = FileUtils.sizeOf(srcDir);
//		System.out.println(size + "byte");

        // 16.文件重命名
//		File srcFile = new File("C:/kang/image/demo_fb.txt");
//		File destFile = new File("C:/kang/image/demo_rename.txt");
//		boolean flag = srcFile.renameTo(destFile);
//		System.out.println(flag);

        // 17.commons.io中FilenameUtils的使用
        // (1)合并目录和文件名为文件全路径
//		String basePath = "C:/kang/image/demo/";
//		String fullFilenameToAdd = "C:/kang/image/demo/demo.txt";
//		String fullFilenameToAdd = "demo.txt";
//		String concatPath = FilenameUtils.concat(basePath, fullFilenameToAdd);
//		System.out.println(concatPath);

        // (2)去除目录和后缀后的文件名
//		String filename = "C:/kang/image/demo/demo.txt";
//		String baseName = FilenameUtils.getBaseName(filename);
//		System.out.println(baseName);

        // (3)获取文件的后缀
//		String filename = "C:/kang/image/demo/demo.txt";
//		String extension = FilenameUtils.getExtension(filename);
//		System.out.println(extension);

        // (4)获取文件的目录
//		String filename = "C:/kang/image/demo/demo.txt";
//		String fullPath = FilenameUtils.getFullPath(filename);
//		System.out.println(fullPath);

        // (5)获取文件名
//		String filename = "C:/kang/image/demo/demo.txt";
//		String name = FilenameUtils.getName(filename);
//		System.out.println(name);

        // (6)去除盘符后的路径
//		String filename = "C:/kang/image/demo/demo.txt";
//		String path = FilenameUtils.getPath(filename);
//		System.out.println(path);

        // (7)盘符
//		String filename = "C:/kang/image/demo/demo.txt";
//		String prefix = FilenameUtils.getPrefix(filename);
//		System.out.println(prefix);

        // (8)获取最后一个.的位置
//		String filename = "C:/kang/image/demo/demo.txt";
//		int indexOfExtension = FilenameUtils.indexOfExtension(filename);
//		System.out.println(indexOfExtension);

        // (9)获取最后一个/的位置
//		String filename = "C:/kang/image/demo/demo.txt";
//		int indexOfLastSeparator = FilenameUtils.indexOfLastSeparator(filename);
//		System.out.println(indexOfLastSeparator);

        // (10)获取当前系统格式化路径
//		String filename = "C:/kang/image/demo/demo.txt";
//		String normalizeName = FilenameUtils.normalize(filename);
//		System.out.println(normalizeName);

        // (11)移除文件的扩展名
//		String filename = "C:/kang/image/demo/demo.txt";
//		String removeExtensionName = FilenameUtils.removeExtension(filename);
//		System.out.println(removeExtensionName);

        // (12)转换分隔符为当前系统分隔符
//		String path = "C:/kang/image/demo/demo.txt";
//		String name = FilenameUtils.separatorsToSystem(path);
//		System.out.println(name);

        // (13)转换分隔符为linux系统分隔符
//		String path = "C:/kang/image/demo/demo.txt";
//		String linuxPath = FilenameUtils.separatorsToUnix(path);
//		System.out.println(linuxPath);

        // (14)转换分隔符为windows系统分隔符
//		String path = "C:/kang/image/demo/demo.txt";
//		String windowsPath = FilenameUtils.separatorsToWindows(path);
//		System.out.println(windowsPath);

        // (15)判断文件路径是否相同，非格式化
//		String filename1 = "C:/kang/image/demo/demo.txt";
//		String filename2 = "C:/kang/image/demo/demo_fb.txt";
//		String filename2 = "C:/kang/image/demo/demo.txt";
//		boolean flag = FilenameUtils.equals(filename1, filename2);
//		System.out.println(flag);

        // (16)判断文件路径是否相同，格式化
//		String filename1 = "C:/kang/image/demo/demo.txt";
//		String filename2 = "C:/kang/image/demo/demo_fb.txt";
//		String filename2 = "C:\\kang\\image\\demo\\demo.txt";
//		boolean flag = FilenameUtils.equalsNormalized(filename1, filename2);
//		System.out.println(flag);

        // (17)判断目录下是否包含指定文件或目录
//		String canonicalParent = "C:/kang/image/demo/";
//		String canonicalChild = "C:/kang/image/demo/demo.txt";
//		boolean flag = FilenameUtils.directoryContains(canonicalParent, canonicalChild);
//		System.out.println(flag);

        // (18)判断文件扩展名是否包含在指定集合(数组、字符串)中
//		String filename = "C:/kang/image/demo/demo.txt";
//		String extension = "txt";
//		String extension = "pdf";
//		boolean flag = FilenameUtils.isExtension(filename, extension);
//		System.out.println(flag);

        // (19)判断文件扩展名是否和指定规则匹配
//		String filename = "C:/kang/image/demo/demo.txt";
//		String wildcardMatcher = "*.txt";
//		boolean flag = FilenameUtils.wildcardMatch(filename, wildcardMatcher);
//		System.out.println(flag);

        // 18.html转换成pdf
//		String srcHtmlPath = "C:/kang/image/tradeDetail1.html";
//		String destPdfPath = "C:/kang/image/tradeDetail1_fb.pdf";
//		convertHtmlToPdf(srcHtmlPath, destPdfPath);

        // 19.文件转base64流
//        String filePath = "C:/kang/image/demo/demo.txt";
//        String fileBase64 = getBase64FromFile(new File(filePath));
//        System.out.println(fileBase64);
    }

}
