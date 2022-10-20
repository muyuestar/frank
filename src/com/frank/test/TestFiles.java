package com.frank.test;

import java.io.File;
import java.nio.file.Files;

/**
 * ≤‚ ‘Files
 * @author kst
 *
 */
public class TestFiles {

	public static void main(String[] args) throws Exception {
		// Files.size
		File file = new File("files//stream.txt");
		long size = Files.size(file.toPath()); // k
		System.out.println("size="+size);
	}
}
