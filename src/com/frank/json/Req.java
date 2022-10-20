package com.frank.json;

/**
 *
 * @author kst
 * @date 2021-08-25 10:38:55
 */
public class Req {
	private Body body;

	private Custom custom;

	private Head head;

	public void setBody(Body body) {
		this.body = body;
	}

	public Body getBody() {
		return this.body;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public Custom getCustom() {
		return this.custom;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Head getHead() {
		return this.head;
	}
}
