package com.frank.util;

/**
 * ͼƬ��ʽ����
 * 
 * @author kst
 * @date 2020-12-14 16:02:25
 */
public class TypeDict {
	 /**�����ļ����ļ�ͷ���£�(��ǰ��λΪ׼)
    JPEG (jpg)���ļ�ͷ��FFD8FF
    PNG (png)���ļ�ͷ��89504E47
    GIF (gif)���ļ�ͷ��47494638
    TIFF (tif)���ļ�ͷ��49492A00
    Windows Bitmap (bmp)���ļ�ͷ��424D
    CAD (dwg)���ļ�ͷ��41433130
    Adobe Photoshop (psd)���ļ�ͷ��38425053
    Rich Text Format (rtf)���ļ�ͷ��7B5C727466
    XML (xml)���ļ�ͷ��3C3F786D6C
    HTML (html)���ļ�ͷ��68746D6C3E
    Email [thorough only] (eml)���ļ�ͷ��44656C69766572792D646174653A
    Outlook Express (dbx)���ļ�ͷ��CFAD12FEC5FD746F
    Outlook (pst)���ļ�ͷ��2142444E
    MS Word/Excel (xls.or.doc)���ļ�ͷ��D0CF11E0
    MS Access (mdb)���ļ�ͷ��5374616E64617264204A
    WordPerfect (wpd)���ļ�ͷ��FF575043
    Postscript (eps.or.ps)���ļ�ͷ��252150532D41646F6265
    Adobe Acrobat (pdf)���ļ�ͷ��255044462D312E
    Quicken (qdf)���ļ�ͷ��AC9EBD8F
    Windows Password (pwl)���ļ�ͷ��E3828596
    ZIP Archive (zip)���ļ�ͷ��504B0304
    RAR Archive (rar)���ļ�ͷ��52617221
    Wave (wav)���ļ�ͷ��57415645
    AVI (avi)���ļ�ͷ��41564920
    Real Audio (ram)���ļ�ͷ��2E7261FD
    Real Media (rm)���ļ�ͷ��2E524D46
    MPEG (mpg)���ļ�ͷ��000001BA
    MPEG (mpg)���ļ�ͷ��000001B3
    Quicktime (mov)���ļ�ͷ��6D6F6F76
    Windows Media (asf)���ļ�ͷ��3026B2758E66CF11
    MIDI (mid)���ļ�ͷ��4D546864
    */
	public static String checkType(String fileType) {
		switch (fileType) {
		case "FFD8FF":
			return "jpg";
		case "89504E":
			return "png";
		case "424D":
			return "bmp";
		default:
			return "0000";
		}
	}
	
}
