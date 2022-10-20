package com.frank.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 生成二维码
 * 
 * @author kst
 * @date 2019-05-06 20:41:01
 */
public class CreateQrCode {
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	public static void main(String[] args) {
		int width = 400;
		int height = 400;
		String format = "png";
		// String url = "http://www.antfin.com";
		// String url = "http://www.imooc.com";
		String url = "http://www.baidu.com";
//		String url = "https://wxtest.beeb.com.cn/wxbank_sit/ShowElectronicReceipt.do?fileNumber=561265d3-70ac-4430-a8af-ae3085ac227a.pdf&fileType=02&key=2e57202902a8e00c13d3e9d1ed9d7393690ef814b0d009e6efcc326c5a66f7e216f2049abff91cee1de3cfb9bd739603cf258449753492e1a028618a328de93ac70353ca2955a25f0c9ae66c6db6585496f47dfc575bc6ac&app_id=2015051100069170&source=alipay_wallet&scope=auth_base&auth_code=bc2b55e8e5694009b0879e27052aSX44";
		String filePath = "C:/kang/image/hutool/wx.png";
		try {
			Map<EncodeHintType, Object> hints = new HashMap<>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			hints.put(EncodeHintType.MARGIN, 2);
			BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
			File file = new File(filePath);
			if (!ImageIO.write(toBufferedImage(bitMatrix), format, file)) {
				System.out.println("生成失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("生成二维码成功");
	}

	private static BufferedImage toBufferedImage(BitMatrix bitMatrix) {
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}
}
