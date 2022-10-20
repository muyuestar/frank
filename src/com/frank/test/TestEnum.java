package com.frank.test;

/**
 * ≤‚ ‘√∂æŸ
 * 
 * @author kst
 *
 */
public enum TestEnum {

	FRANK("The given name of me"), LIU("The family name of me");
	private String context;

	private String getContext() {
		return this.context;
	}

	private TestEnum(String context) {
		this.context = context;
	}

	public static void main(String[] args) {
		for (TestEnum name : TestEnum.values()) {
			System.out.println(name + " : " + name.getContext());
		}
		System.out.println(TestEnum.FRANK.getDeclaringClass());
	}
}
