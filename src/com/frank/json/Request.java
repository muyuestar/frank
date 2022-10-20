package com.frank.json;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author kst
 * @date 2021-08-25 10:38:55
 */
public class Request implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JSONObject body;

	private JSONObject head;

	public JSONObject getBody() {
		return body;
	}

	public void setBody(JSONObject body) {
		this.body = body;
	}

	public JSONObject getHead() {
		return head;
	}

	public void setHead(JSONObject head) {
		this.head = head;
	}

}
