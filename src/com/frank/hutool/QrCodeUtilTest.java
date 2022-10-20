package com.frank.hutool;

import java.awt.image.BufferedImage;
import java.io.File;

import com.google.zxing.BarcodeFormat;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.system.HostInfo;
import cn.hutool.system.SystemUtil;

/**
 *
 * @author kst
 * @version ����ʱ�䣺2020��8��28�� ����4:58:53
 */
public class QrCodeUtilTest {

	public static void main(String[] args) {
//		QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("C:/kang/image/hutool/qrcode.jpg"));
//		QrCodeUtil.generate(//
//				"http://hutool.cn/", //
//				QrConfig.create().setImg("C:/kang/image/cherryblossorm.jpg"), //
//				FileUtil.file("C:/kang/image/hutool/qrcodeWithLogo.jpg"));
		
		QrCodeUtil.generate(//
				"ƾ֤�ص���ά��    ������    ��������    ���׹�Ա    ƾ֤�ص���ά��    ������    ��������    ���׹�Ա", //
				QrConfig.create().setImg("C:/kang/image/cherryblossorm.jpg"), //
				FileUtil.file("C:/kang/image/hutool/qrcodeWithLogo.jpg"));

//		QrConfig config = new QrConfig();
//		config.setMargin(2);
//		config.setForeColor(Color.blue);
		// ����ɫ͸��
//		config.setBackColor(null);
//		config.setErrorCorrection(ErrorCorrectionLevel.H);
//		QrCodeUtil.generate("http://hutool.cn/", config, FileUtil.file("C:/kang/image/hutool/qrcodeCustom.png"));
//		String decode = QrCodeUtil.decode(FileUtil.file("C:/kang/image/hutool/qrcodeCustom.png"));
//		System.out.println("�ɹ�");
//		System.out.println(decode);

//		QrConfig config = new QrConfig();
//		config.setWidth(400);
//		config.setHeight(250);
//		BufferedImage image = QrCodeUtil.generate("1234567899", BarcodeFormat.CODABAR, config);
//		ImgUtil.write(image, new File("C:/kang/image/hutool/codabar.jpg"));
//		System.out.println("�ɹ�");
		
//		HostInfo hostInfo = SystemUtil.getHostInfo();
//		System.out.println(hostInfo.toString());
	}

}
