package com.frank.filetohtml;

import com.frank.util.FileOperationUtils;

/**
 * Excel�ĵ�ת����html
 * 
 * @author kst
 * @date 2019-08-14 22:47:40
 */
public class PoiExcelToHtml {

	public static void main(String[] args) throws Exception {
		System.out.println("Excel�ĵ���ʼת����html");
		String excelFilePath = "E:\\test\\";
		String excelFileName = "video.xls";
		String htmlName = "video.html";
		FileOperationUtils.poiExcelToHtml(excelFilePath, excelFileName, htmlName);
		System.out.println("Excel�ĵ�ת����html����");
	}
}
