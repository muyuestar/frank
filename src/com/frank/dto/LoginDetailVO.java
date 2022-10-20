package com.frank.dto;

/**
 * 登录返回DTO
 * 
 * @author kst
 * @date 2021-08-03 11:34:00
 */
public class LoginDetailVO {
	// 登录账号
	private String loginName;

	// 员工名称
	private String actualName;

	// 手机号码
	private String phone;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getActualName() {
		return actualName;
	}

	public void setActualName(String actualName) {
		this.actualName = actualName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
