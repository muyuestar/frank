package com.frank.filetohtml;

import com.frank.util.FileOperationUtils;

/**
 * Excel文档转换成html
 * 
 * @author kst
 * @date 2019-08-14 22:47:40
 */
public class PoiExcelToHtml {

	public static void main(String[] args) throws Exception {
		System.out.println("Excel文档开始转换成html");
		String excelFilePath = "E:\\test\\";
		String excelFileName = "video.xls";
		String htmlName = "video.html";
		FileOperationUtils.poiExcelToHtml(excelFilePath, excelFileName, htmlName);
		System.out.println("Excel文档转换成html结束");
	}
}
