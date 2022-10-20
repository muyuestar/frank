package com.frank.productAI;

import java.io.File;

import cn.productai.api.core.DefaultProductAIClient;
import cn.productai.api.core.DefaultProfile;
import cn.productai.api.core.IProfile;
import cn.productai.api.core.IWebClient;
import cn.productai.api.core.enums.LanguageType;
import cn.productai.api.pai.entity.classify.ClassifyByImageFileRequest;
import cn.productai.api.pai.entity.classify.ClassifyResponse;

/**
 * 时尚分析服务
 * 
 * @author kst
 * @date 2020年1月7日 下午5:12:26
 * 
 */
public class FashionAnalysis {

	public static void main(String[] args) throws Exception {
		// 设置API调用初始化参数
		IProfile profile = new DefaultProfile();
		profile.setAccessKeyId(Common.ACCESS_KEY_ID);
		profile.setSecretKey(Common.SECRET_KEY);
		profile.setVersion("1");
		profile.setGlobalLanguage(LanguageType.Chinese);
		IWebClient client = new DefaultProductAIClient(profile);

		// 使用URL作为参数调用API
//		ClassifyByImageUrlRequest request = new ClassifyByImageUrlRequest("dressing", "_0000111");
//		request.setUrl("https://yyyy");

		// 或者使用本地文件作为参数调用API
		ClassifyByImageFileRequest request = new ClassifyByImageFileRequest("dressing", "_0000111");
		request.setImageFile(new File("zzzz.jpg"));
		request.setLanguage(LanguageType.Chinese);

		ClassifyResponse response = client.getResponse(request);
		String json = response.getResponseJsonString();
		System.out.println(json);
	}
}
