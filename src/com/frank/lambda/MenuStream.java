package com.frank.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

/**
 *
 * @author kst
 * @date 2021-11-21 20:52:16
 */
public class MenuStream {

	public static void main(String[] args) {
		List<Menu> menus = Arrays.asList(
				new Menu(1, "���ڵ�", 0), 
				new Menu(2, "�ӽڵ�1", 1), 
				new Menu(3, "�ӽڵ�1.1", 2),
				new Menu(4, "�ӽڵ�1.2", 2), 
				new Menu(5, "���ڵ�1.3", 2), 
				new Menu(6, "���ڵ�2", 1), 
				new Menu(7, "���ڵ�2.1", 6),
				new Menu(8, "���ڵ�2.2", 6), 
				new Menu(9, "���ڵ�2.2.1", 8), 
				new Menu(10, "���ڵ�2.2.2", 8),
				new Menu(11, "���ڵ�3", 1), 
				new Menu(12, "���ڵ�3.1", 11));
		
		// ��ȡ���ڵ�
		List<Menu> listMenu = menus.stream().filter(m -> m.getParentId() == 0).map((m) -> {
			m.setChildList(getChildrens(m, menus));
			return m;
		}).collect(Collectors.toList());
		System.out.println(JSON.toJSON(listMenu));
	}
	
	/**
	 * �ݹ��ѯ�ӽڵ�
	 * 
	 * @param root ���ڵ�
	 * @param all  ���нڵ�
	 * @return ���ڵ���Ϣ
	 */
	private static List<Menu> getChildrens(Menu root, List<Menu> all) {
		List<Menu> children = all.stream().filter(m -> {
			return Objects.equals(m.getParentId(), root.getId());
		}).map((m) -> {
			m.setChildList(getChildrens(m, all));
			return m;
		}).collect(Collectors.toList());
		return children;
	}
	
}
