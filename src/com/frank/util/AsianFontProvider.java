package com.frank.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;

/**
 * ×ÖÌå·½·¨
 * 
 * @author kst
 * @date 2021-09-16 20:18:59
 */
public class AsianFontProvider extends XMLWorkerFontProvider {
	public Font getFont(final String fontname, final String encoding, final boolean embedded, final float size,
			final int style, final BaseColor color) {
		try {
			BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/SIMHEI.TTF", BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);
//			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font font = new Font(baseFont, size, style, color);
			font.setColor(color);
			return font;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
