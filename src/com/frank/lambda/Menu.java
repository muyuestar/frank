package com.frank.lambda;

import java.util.List;

/**
 * �˵�ʵ����
 * 
 * @author kst
 * @date 2021-11-21 20:48:32
 */
public class Menu {

	// id
	public Integer id;
	// ����
	public String name;
	// ��id�����ڵ�Ϊ0
	public Integer parentId;
	// �ӽڵ���Ϣ
	public List<Menu> childList;

	public Menu(Integer id, String name, Integer parentId) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	public Menu(Integer id, String name, Integer parentId, List<Menu> childList) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.childList = childList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Menu> getChildList() {
		return childList;
	}

	public void setChildList(List<Menu> childList) {
		this.childList = childList;
	}

}
