package com.frank.dto;

/**
 * ��¼����DTO
 * 
 * @author kst
 * @date 2021-08-03 11:34:00
 */
public class LoginDetailVO {
	// ��¼�˺�
	private String loginName;

	// Ա������
	private String actualName;

	// �ֻ�����
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
