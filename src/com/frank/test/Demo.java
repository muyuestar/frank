package com.frank.test;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Demo {

	public static void main(String[] args) throws IOException, InterruptedException {
//		System.out.println("��ʼת��");
//		String imgFilePath = "E:\\image\\�����˻�����������.jpg";
//		String pdfFilePath = "E:\\image\\�����˻�����������.pdf";
//		long startTime = System.currentTimeMillis();
//		ImageUtils.convertImgToPdf(imgFilePath, pdfFilePath);
//		long endTime = System.currentTimeMillis();
//		System.out.println("��ʱ="+(endTime-startTime));
//		System.out.println("ת������");

//		System.out.println("��ʼת��");
//		String imgFilePath = "E:\\image\\�����˻�����������.jpg";
//		File file = new File(imgFilePath);
//		ImageUtils.compressPictureByQality(file, 0.15f);
//		System.out.println("ת������");

//		System.out.println("��ʼ�ϳ�");
//		String pdfFilePath = "E:/image/kst.pdf";
//		String imgFilePath = "E:/image/17.jpg";
//		PdfUtils.pdfAddImage(pdfFilePath, imgFilePath);
//		System.out.println("�ϳɽ���");

//		System.out.println("��ʼУ��");
//		String pdfFilePath = "C:/kang/image/kst.pdf";
//		boolean flag = PdfUtils.checkPdfFile(pdfFilePath);
//		System.out.println(flag);
//		System.out.println("У�����");

//		System.out.println("��ʼ�ü�");
//		String originalImagePath = "E:/image/yzyh.jpg";
//		String clipImagePath = "E:/image/yzyh_1.jpg";
//		int[] res = ImageUtils.getImageWidthAndLength(originalImagePath);
//		int width = res[0];
//		int height = res[1];
//		boolean flag = ImageUtils.clipImage(originalImagePath, clipImagePath, 0, 130, width, height);
//		if (flag) {
//			System.out.println("�ü��ɹ�");
//		} else {
//			System.out.println("�ü�ʧ��");
//		}

//		System.out.println("��ʼ�ϳ�");
//		String originalPdfFilePath = "E:/image/�������л����Ҫ.pdf";
//		String composePdfFilePath = "E:/image/�������л����Ҫ_1.pdf";
//		String imgFilePath = "E:/image/wzseal.png";
//		
//		PdfUtils.pdfAddImg(originalPdfFilePath, composePdfFilePath, imgFilePath, 50, 50, "100");
//		System.out.println("�ϳɳɹ�");

//		String originalImagePath = "C:\\kang\\image\\zoom\\17.jpg";
//		String zoomImagePath = "C:\\kang\\image\\zoom\\17_1.jpg";
//		boolean flag = ImageUtils.zoomImage(originalImagePath, zoomImagePath, 500, 330);
//		System.out.println(flag);

//		UnionAPI unionAPI = new UnionAPI("192.168.0.114",8537,8080,"11");
//		unionAPI.toString();

//		System.out.println("��ʼ�ϳ�");
//		File file = new File("C:/kang/image/wzh.pdf"); 
//		System.out.println(file.length());
//		System.out.println("�ϳɳɹ�");

//		Map<String, String> map = new HashMap<>();
//		map.put("a", "1");
//		map.put("b", "NULL");
//		map.put("c", "NULL");
//		System.out.println(map.toString());
//
//		for (Map.Entry<String, String> entry : map.entrySet()) {
//			if ("NULL".equals(entry.getValue())) {
//				map.put(entry.getKey(), "");
//			}
//		}
//		System.out.println(map.toString());
//		System.out.println(Charset.defaultCharset());

//		String str = "C:/kang/image/svg/demo.png|12";
//		System.out.println(str.split("\\|")[0]);
//		System.out.println(str.split("\\|")[1]);

//		Pattern pattern = Pattern.compile("^[0-9]+$");
//		Matcher isNum = pattern.matcher(".12345");
//		if (isNum.matches()) {
//			System.out.println("ƥ��");
//		} else {
//			System.out.println("δƥ��");
//		}

//		String str = "123</Body>";
//		int index = str.lastIndexOf("</Body");
//		System.out.println(index);

//		String str = "abc|123|i am ok.";
//		String[] strArray = str.split("\\|");
//		System.out.println(strArray[0]);
//		System.out.println(strArray[1]);
//		System.out.println(strArray[2]);

//		StringBuffer sb = new StringBuffer();
//		sb.append("11").append("\n");
//		sb.append("22").append("\n");
//		sb.append("33").append("\n");
//		String str = sb.toString();
//		System.out.println(str);
//		System.out.println(str.split("\n").length);
//		System.out.println("-----------------------");
//
//		String subStr = (String) str.subSequence(0, str.lastIndexOf("\n"));
//		System.out.println(subStr);
//		System.out.println("-----------------------");
//
//		subStr = (String) str.substring(0, str.lastIndexOf("\n"));
//		System.out.println(subStr);
//		System.out.println("-----------------------");

//		String[] array = new String[] { "1", "2", "3", "4", "5" };
//		int[] ins = new int[] {0,1,2,3,4};
//		System.out.println(Arrays.toString(array));
//		
//		for(int i = 0 ;i<array.length;i++) {
//			array[i] = null;
//		}
//		
//		System.out.println(Arrays.toString(array));

//		StringBuffer sb = new StringBuffer();
//		sb.append("aaa").append("\n");
//		sb.append("bbb").append("\n");
//		sb.append("ccc").append("\n");
//		System.out.println(sb.toString());
//
//		try {
//			PrintStream ps = new PrintStream(new FileOutputStream(new File("C:/kang/image/wz/10-9.txt")));
//			String[] excelArray = sb.toString().split("\n");
//			for (int i = 0; i < excelArray.length; i++) {
//				ps.println(excelArray[i]);
//			}
//			ps.println("http://www.docin.com/p-315288370.html");// ���ļ���д���ַ���
//			ps.append("http://www.docin.com/p-315288371.html");// �����еĻ���������ַ���
//			ps.flush();
//			ps.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("ִ�����");

//		System.out.println(Integer.valueOf("fffe",16).toString());
//		System.out.println(Integer.toBinaryString(0xfffe));

		// String->ByteBuffer
//		String content = "abc��Һ�";
//		ByteBuffer bb = ByteBuffer.wrap(content.getBytes("utf-8"));
//		System.out.println(bb);
//		
//		// ByteBuffer->String
//		String str = Charset.forName("utf-8").decode(bb).toString();
//		System.out.println(str);

//		int a = 5;
//		String str = (a & 1) == 0 ? "ż��" : "����";
//		System.out.println(str);
		
//		String jsonStr = "{\"HY\":{\"coordX\":\"10\"},\"demo\":\"111\"}";
////		Map<String, String> map = JSON.parseObject(jsonStr, Map.class);
//		Map<String, Object> map = JSONObject.parseObject(jsonStr);
//		System.out.println(map);
//		System.out.println(map.get("HY").toString());
	}

}
