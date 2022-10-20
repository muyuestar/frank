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
//		System.out.println("开始转换");
//		String imgFilePath = "E:\\image\\个人账户开户申请书.jpg";
//		String pdfFilePath = "E:\\image\\个人账户开户申请书.pdf";
//		long startTime = System.currentTimeMillis();
//		ImageUtils.convertImgToPdf(imgFilePath, pdfFilePath);
//		long endTime = System.currentTimeMillis();
//		System.out.println("耗时="+(endTime-startTime));
//		System.out.println("转换结束");

//		System.out.println("开始转换");
//		String imgFilePath = "E:\\image\\个人账户开户申请书.jpg";
//		File file = new File(imgFilePath);
//		ImageUtils.compressPictureByQality(file, 0.15f);
//		System.out.println("转换结束");

//		System.out.println("开始合成");
//		String pdfFilePath = "E:/image/kst.pdf";
//		String imgFilePath = "E:/image/17.jpg";
//		PdfUtils.pdfAddImage(pdfFilePath, imgFilePath);
//		System.out.println("合成结束");

//		System.out.println("开始校验");
//		String pdfFilePath = "C:/kang/image/kst.pdf";
//		boolean flag = PdfUtils.checkPdfFile(pdfFilePath);
//		System.out.println(flag);
//		System.out.println("校验结束");

//		System.out.println("开始裁剪");
//		String originalImagePath = "E:/image/yzyh.jpg";
//		String clipImagePath = "E:/image/yzyh_1.jpg";
//		int[] res = ImageUtils.getImageWidthAndLength(originalImagePath);
//		int width = res[0];
//		int height = res[1];
//		boolean flag = ImageUtils.clipImage(originalImagePath, clipImagePath, 0, 130, width, height);
//		if (flag) {
//			System.out.println("裁剪成功");
//		} else {
//			System.out.println("裁剪失败");
//		}

//		System.out.println("开始合成");
//		String originalPdfFilePath = "E:/image/温州银行会议纪要.pdf";
//		String composePdfFilePath = "E:/image/温州银行会议纪要_1.pdf";
//		String imgFilePath = "E:/image/wzseal.png";
//		
//		PdfUtils.pdfAddImg(originalPdfFilePath, composePdfFilePath, imgFilePath, 50, 50, "100");
//		System.out.println("合成成功");

//		String originalImagePath = "C:\\kang\\image\\zoom\\17.jpg";
//		String zoomImagePath = "C:\\kang\\image\\zoom\\17_1.jpg";
//		boolean flag = ImageUtils.zoomImage(originalImagePath, zoomImagePath, 500, 330);
//		System.out.println(flag);

//		UnionAPI unionAPI = new UnionAPI("192.168.0.114",8537,8080,"11");
//		unionAPI.toString();

//		System.out.println("开始合成");
//		File file = new File("C:/kang/image/wzh.pdf"); 
//		System.out.println(file.length());
//		System.out.println("合成成功");

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
//			System.out.println("匹配");
//		} else {
//			System.out.println("未匹配");
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
//			ps.println("http://www.docin.com/p-315288370.html");// 往文件里写入字符串
//			ps.append("http://www.docin.com/p-315288371.html");// 在已有的基础上添加字符串
//			ps.flush();
//			ps.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("执行完成");

//		System.out.println(Integer.valueOf("fffe",16).toString());
//		System.out.println(Integer.toBinaryString(0xfffe));

		// String->ByteBuffer
//		String content = "abc大家好";
//		ByteBuffer bb = ByteBuffer.wrap(content.getBytes("utf-8"));
//		System.out.println(bb);
//		
//		// ByteBuffer->String
//		String str = Charset.forName("utf-8").decode(bb).toString();
//		System.out.println(str);

//		int a = 5;
//		String str = (a & 1) == 0 ? "偶数" : "奇数";
//		System.out.println(str);
		
//		String jsonStr = "{\"HY\":{\"coordX\":\"10\"},\"demo\":\"111\"}";
////		Map<String, String> map = JSON.parseObject(jsonStr, Map.class);
//		Map<String, Object> map = JSONObject.parseObject(jsonStr);
//		System.out.println(map);
//		System.out.println(map.get("HY").toString());
	}

}
