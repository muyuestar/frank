package com.frank.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Java�������JS����
 * 
 * @author kst
 * @date 2021-08-16 11:23:07
 */
public class TestScriptEngine {

	/**
	 * java����expression.js�е�merge����
	 * 
	 * @throws Exception
	 * @author kst 20210816
	 */
	public static void mergeJs() throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		// ��ȡjs�ļ�
		String jsFileName = "C:/kang/tools/eclipse/workspace/frank/src/com/frank/js/expression.js";
		// ִ��ָ���ű�
		FileReader reader = new FileReader(jsFileName);
		engine.eval(reader);
		if (engine instanceof Invocable) {
			// ����merge��������������������
			Invocable invoke = (Invocable) engine;
			// c = merge(2, 3);
			Double c = (Double) invoke.invokeFunction("merge", 2, 3);
			System.out.println("c = " + c);
		} else {
			System.out.println("����ʧ��");
		}
	}

	public static void encryptPin() throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		// ��ȡjs�ļ�
		String jsFileName = "C:/kang/tools/eclipse/workspace/frank/src/com/frank/js/sm4.js";
		// ִ��ָ���ű�
		FileReader reader = new FileReader(jsFileName);
		engine.eval(reader);
		if (engine instanceof Invocable) {
			// ����merge��������������������
			Invocable invoke = (Invocable) engine;
			String encryptPassword = (String) invoke.invokeFunction("sm4", "000000", "64F3BC528091A3649A0C9EAEFFAA32B4",
					"1", "");
			System.out.println("encryptPassword=" + encryptPassword);
		} else {
			System.out.println("����ʧ��");
		}
	}

	public static void main(String[] args) throws Exception {
		encryptPin();
	}

}
