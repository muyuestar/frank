package com.frank.filetohtml;

import com.frank.util.FileOperationUtils;

/**
 * word文档转换成html
 * 
 * @author kst
 * @date 2019-08-05 17:54:33
 */
public class PoiWordToHtml {

	public static void main(String[] args) throws Exception {
		System.out.println("word文档开始转换成html");
		String wordFilePath = "E:\\test\\";
		String wordFileName = "demo.doc";
		String htmlName = "demo.html";
		FileOperationUtils.poiWordToHtml(wordFilePath, wordFileName, htmlName);
		System.out.println("word文档转换成html结束");
	}
}