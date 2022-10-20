package com.frank.test;

import java.security.CodeSource;
import java.security.ProtectionDomain;

import org.apache.commons.lang3.StringUtils;

/**
 * ��ȡimport ������Ŀ¼
 * @author kst 2018.11.20
 *
 */
public class GetImportDir {

	public static void main(String[] args) {
		ProtectionDomain pd = StringUtils.class.getProtectionDomain();
		CodeSource cs = pd.getCodeSource();
		System.out.println(cs.getLocation());
	}
}
