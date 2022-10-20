package com.frank.json;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author kst
 * @date 2021-09-02 21:23:30
 */
public class Requ implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, String> head;

	private Map<String, Object> body;

	private Map<String, String> AMLField;

	public Map<String, String> getHead() {
		return head;
	}

	public void setHead(Map<String, String> head) {
		this.head = head;
	}

	public Map<String, Object> getBody() {
		return body;
	}

	public void setBody(Map<String, Object> body) {
		this.body = body;
	}

	public Map<String, String> getAMLField() {
		return AMLField;
	}

	public void setAMLField(Map<String, String> aMLField) {
		AMLField = aMLField;
	}

}
