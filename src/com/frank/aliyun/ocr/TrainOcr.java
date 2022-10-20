package com.frank.aliyun.ocr;

import static org.apache.commons.codec.binary.Base64.encodeBase64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 印刷文字识别-火车票识别/OCR文字识别
 * https://market.aliyun.com/products/57124001/cmapi020096.html?spm=5176.730005.productlist.d_cmapi020096.6d563524lDu2tD&innerSource=search#sku=yuncode1409600000
 * 使用APPCODE进行云市场ocr服务接口调用
 * 
 * @author kst
 * @version 创建时间：2020年1月10日 下午5:21:39
 */
public class TrainOcr {

	public static void main(String[] args) {
		String host = "https://ocrhcp.market.alicloudapi.com";
		String path = "/api/predict/ocr_train_ticket";
		String appcode = "637c93d25e144aae9646ac19ae0fb2a1";
		String imgFile = "C:\\kang\\image\\aliyunocr\\train.jpg";
		Boolean is_old_format = false; // 如果文档的输入中含有inputs字段，设置为True， 否则设置为False
		// 请根据线上文档修改configure字段
		// JSONObject configObj = new JSONObject();
		// configObj.put("multi_crop", false);
		// String config_str = configObj.toString();
		// configObj.put("min_size", 5);
		String config_str = "";

		String method = "POST";
		Map<String, String> headers = new HashMap<String, String>();
		// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);

		Map<String, String> querys = new HashMap<String, String>();

		// 对图像进行base64编码
		String imgBase64 = "";
		try {
			File file = new File(imgFile);
			byte[] content = new byte[(int) file.length()];
			FileInputStream finputstream = new FileInputStream(file);
			finputstream.read(content);
			finputstream.close();
			imgBase64 = new String(encodeBase64(content));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		// 拼装请求body的json字符串
		JSONObject requestObj = new JSONObject();
		try {
			if (is_old_format) {
				JSONObject obj = new JSONObject();
				obj.put("image", getParam(50, imgBase64));
				if (config_str.length() > 0) {
					obj.put("configure", getParam(50, config_str));
				}
				JSONArray inputArray = new JSONArray();
				inputArray.add(obj);
				requestObj.put("inputs", inputArray);
			} else {
				requestObj.put("image", imgBase64);
				if (config_str.length() > 0) {
					requestObj.put("configure", config_str);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String bodys = requestObj.toString();

		try {
			/**
			 * 重要提示如下: HttpUtils请从
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
			 * 下载
			 *
			 * 相应的依赖请参照
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
			 */
			HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
			int stat = response.getStatusLine().getStatusCode();
			if (stat != 200) {
				System.out.println("Http code: " + stat);
				System.out.println("http header error msg: " + response.getFirstHeader("X-Ca-Error-Message"));
				System.out.println("Http body error msg:" + EntityUtils.toString(response.getEntity()));
				return;
			}

			String res = EntityUtils.toString(response.getEntity());
			JSONObject res_obj = JSON.parseObject(res);
			if (is_old_format) {
				JSONArray outputArray = res_obj.getJSONArray("outputs");
				String output = outputArray.getJSONObject(0).getJSONObject("outputValue").getString("dataValue");
				JSONObject out = JSON.parseObject(output);
				System.out.println(out.toJSONString());
			} else {
				System.out.println(res_obj.toJSONString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * 获取参数的json对象
	 */
	public static JSONObject getParam(int type, String dataValue) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("dataType", type);
			obj.put("dataValue", dataValue);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
