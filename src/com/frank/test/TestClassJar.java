package com.frank.test;

import java.security.CodeSource;
import java.security.ProtectionDomain;

import org.apache.commons.lang3.StringUtils;

/**
 * 查看运行时某个类文件所在jar的位置
 * 
 * @author kst
 * @date 2019-07-17 17:22:04
 */
public class TestClassJar {

	public static void main(String[] args) {
		ProtectionDomain pd = StringUtils.class.getProtectionDomain();
		CodeSource cs = pd.getCodeSource();
		System.out.println(cs.getLocation());
	}
}
