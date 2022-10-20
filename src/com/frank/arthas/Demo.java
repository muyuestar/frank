package com.frank.arthas;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author kst
 * @date 2019年12月10日 上午11:32:33
 * 
 */
public class Demo {

	public static void main(String[] args) throws IOException {
		String[] command = { "netstat", "-ano", "-p", "TCP" };
        List<String> lines = ExecutingCommand.runNative(command);
        System.out.println(lines.get(5));
        String[] strings = lines.get(5).trim().split("\\s+");
        System.out.println(Arrays.toString(strings));
        System.out.println(Integer.parseInt(strings[4]));
	}
}
