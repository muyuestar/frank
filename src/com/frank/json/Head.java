package com.frank.json;

/**
 *
 * @author kst
 * @date 2021-08-25 10:38:34
 */
public class Head {
	private String branch;

	private String channel;

	private String charset;

	private String grantTeller;

	private String ipAddr;

	private int reqSerial;

	private String reqTransdate;

	private String reqTranstime;

	private String teller;

	private String transCode;

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBranch() {
		return this.branch;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getCharset() {
		return this.charset;
	}

	public void setGrantTeller(String grantTeller) {
		this.grantTeller = grantTeller;
	}

	public String getGrantTeller() {
		return this.grantTeller;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getIpAddr() {
		return this.ipAddr;
	}

	public void setReqSerial(int reqSerial) {
		this.reqSerial = reqSerial;
	}

	public int getReqSerial() {
		return this.reqSerial;
	}

	public void setReqTransdate(String reqTransdate) {
		this.reqTransdate = reqTransdate;
	}

	public String getReqTransdate() {
		return this.reqTransdate;
	}

	public void setReqTranstime(String reqTranstime) {
		this.reqTranstime = reqTranstime;
	}

	public String getReqTranstime() {
		return this.reqTranstime;
	}

	public void setTeller(String teller) {
		this.teller = teller;
	}

	public String getTeller() {
		return this.teller;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public String getTransCode() {
		return this.transCode;
	}
}
