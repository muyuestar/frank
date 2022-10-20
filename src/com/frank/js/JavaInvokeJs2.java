package com.frank.js;

import java.io.FileReader;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Java代码调用js代码简化版
 * 
 * @author kst
 * @date 2021-12-08 20:31:26
 */
public class JavaInvokeJs2 {

	public static void main(String[] args) throws Exception, ScriptException {
		// 获取JS执行引擎
		ScriptEngine se = new ScriptEngineManager().getEngineByName("javascript");
		// 获取变量
		Bindings bindings = se.createBindings();
		bindings.put("number", 3);
		se.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
		se.eval(new FileReader("C:/kang/tools/eclipse/workspace/frank/src/com/frank/js/test.js"));
		// 是否可调用
		if (se instanceof Invocable) {
			Invocable in = (Invocable) se;
			Double result = (Double) in.invokeFunction("add", 1, 2);
			System.out.println("获得的结果：" + result);
		} else {
			System.out.println("java调用js失败！");
		}
	}

}
