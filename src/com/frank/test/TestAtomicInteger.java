package com.frank.test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * ≤‚ ‘AtomicInteger
 * 
 * @author kst
 *
 */
public class TestAtomicInteger {

	public static void main(String[] args) throws Exception {
		AtomicInteger atomicInteger = new AtomicInteger();
		List<String> sentences = Files.readAllLines(Paths.get("files/stream.txt")).stream().map(line -> line.trim())
				.filter(line -> line.length() > 1).collect(Collectors.toList());
		sentences.forEach(sentence -> atomicInteger.addAndGet(sentence.length()));
		System.out.println("≥§∂»=" + atomicInteger.get());
	}
}
