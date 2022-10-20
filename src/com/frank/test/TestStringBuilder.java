package com.frank.test;

/**
 * ²âÊÔStringBuilder
 * 
 * @author kst
 *
 */
public class TestStringBuilder {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("1").append("2").append("3").append("4").append("5");
		System.out.println("³õÊ¼×Ö·û´®=" + sb.toString());
		sb.insert(1, "a");
		System.out.println("²åÈëºóµÄ×Ö·û´®=" + sb.toString());
	}
}
