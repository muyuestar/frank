package com.frank.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * XML½âÎö
 * 
 * @author kst 2019-09-16
 *
 */
public class XmlParse {

	public static void main(String[] args) throws DocumentException {
		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><BatchBean MODEL_CODE=\"GM\" IS_UNITED_ACCESS=\"false\" IS_SUNECM_COSOLE=\"false\" IS_BREAK_POINT=\"false\" IS_DOWNLOAD=\"false\">  <index_Object CONTENT_STATUS=\"1\" SERVER_ID=\"1\" UPLOAD_USER=\"admin\" CONTENT_ID=\"20190911_27_EC147909-9761-C0FD-4E22-56DA7E0FC2D7-1\" MIGRATION_STATUS=\"1\" VERSION=\"1\" MAX_VERSION=\"1\" GROUP_ID=\"1\" GROUP_NAME=\"ZH_GROUP\">    <customMap>      <CREATEDATE><string>20190911</string></CREATEDATE>      <BUSI_ACCOUNT><string></string></BUSI_ACCOUNT>      <CREDENTIAL_TYPE><string></string></CREDENTIAL_TYPE>      <NEAR_PATH><string>20190911/27/</string></NEAR_PATH>      <ACCOUNT><string></string></ACCOUNT>      <UPLOAD_TIME_OLD><string></string></UPLOAD_TIME_OLD>      <CREDENTIAL_NO><string></string></CREDENTIAL_NO>      <OFFLINE_TIME><string></string></OFFLINE_TIME>      <AMOUNT><string>0</string></AMOUNT>      <CUSTOMER><string></string></CUSTOMER>      <BUSI_SERIAL_ID><string></string></BUSI_SERIAL_ID>      <BUSI_DT><string></string></BUSI_DT>      <BUSI_MODEL><string></string></BUSI_MODEL>      <BUSI_DATE><string></string></BUSI_DATE>      <BUSI_START_TIME><string></string></BUSI_START_TIME>      <BUSI_SERIAL_NO><string></string></BUSI_SERIAL_NO>    </customMap>  </index_Object>  <document_Objects>    <BatchFileBean FILE_PART_NAME=\"GM_PART\">      <files>        <FileBean VERSION=\"1\" UPLOAD_TIME=\"20190911152438\" FILE_FORMAT=\"pdf\" FILE_NO=\"C17B4CF8-6639-C770-9FC3-807700AD4A34\" SAVE_NAME=\"C17B4CF8-6639-C770-9FC3-807700AD4A34\" CONTENT_ID=\"20190911_27_EC147909-9761-C0FD-4E22-56DA7E0FC2D7-1\" FILE_STATUS=\"1\" FILE_NAME=\"/home/weblogic/data/xgm/20190911/27/C17B4CF8-6639-C770-9FC3-807700AD4A34\" OPTION_TYPE=\"1\" FILE_SIZE=\"44787\" SERVER_ID=\"1\" GROUP_ID=\"1\" URL=\"http://20.100.17.53:7002/SunECMDM/servlet/getFile?s/lV3bcibQhXB18Qo1llBH5LnV9RN+HoDGgl1+0mTaoL0Xg6DblBtMnC1nBEscWo5qIi5RENBegzJMDeQSUDgyR4nboocXNx1USD9Km0+bhiLCzPoC1qIop1TTV/wwGzkYwvnm6N5wWzKuzK6MTHrusI7V8+RbYoAwDltd8bYasxL8GGEGHwGQSPTd/Cq+RPD7+OYejLRluLiexZocWcGgFDxL5PpTWgKzn/6+x0ODo2v2xn3oDisHySIJptajNskp53wK5PScNxQ8V4pXSFKQ==\" FILE_PATH=\"20190911/27/\" VOLUME_ID=\"24\">          <otherAtt>            <BUSI_FILE_TYPE><string></string></BUSI_FILE_TYPE>            <VALID_PERIOD><string></string></VALID_PERIOD>            <IS_INDEXTYPE><string>0</string></IS_INDEXTYPE>            <TRUENAME><string></string></TRUENAME>            <BUSI_FILE_SCANUSER><string></string></BUSI_FILE_SCANUSER>            <BUSI_RECYLE_FLAG><string></string></BUSI_RECYLE_FLAG>            <SCAN_SERIAL_NO><string></string></SCAN_SERIAL_NO>            <FILEFACE><string></string></FILEFACE>            <NEAR_PATH><string></string></NEAR_PATH>            <BUSI_FILE_PAGENUM><string></string></BUSI_FILE_PAGENUM>            <UPLOAD_TIME_OLD><string></string></UPLOAD_TIME_OLD>            <SF><string></string></SF>            <RESERVE><string></string></RESERVE>            <FILEFORM><string></string></FILEFORM>            <FILEMD5><string></string></FILEMD5>            <SHOWNAME><string></string></SHOWNAME>            <FILEATTR><string></string></FILEATTR>            <FILENAME><string></string></FILENAME>          </otherAtt>        </FileBean>      </files>    </BatchFileBean>  </document_Objects></BatchBean></root>";
		Document doc = DocumentHelper.parseText(xmlStr);
		Element root = doc.getRootElement();
		Element batchBean = root.element("BatchBean");
		Element document_Objects = batchBean.element("document_Objects");
		Element batchFileBean = document_Objects.element("BatchFileBean");
		Element files = batchFileBean.element("files");
		Element fileBean = files.element("FileBean");
		String url = fileBean.attribute("URL").getValue();
		System.out.println(url);
	}
}
