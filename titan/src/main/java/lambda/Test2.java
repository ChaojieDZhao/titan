package lambda;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * 
 * Test2 下午4:00:07
 * 
 * Copyright zhaocj Inc. All rights reserved. Love ME Like Justin Bieber.
 */
public class Test2 {
	public static void main(String[] args) throws Exception {
		new Thread(() -> System.out.println("Hello World!")).start();
		TimeUnit.SECONDS.sleep(1000);
	}

	@Test
	public void test1() {
		String[] datas = new String[] { "peng", "zhao", "li" };
		Arrays.sort(datas);
		Stream.of(datas).forEach(param -> System.out.println(param));
	}

	@Test
	public void test2() {
		String[] datas = new String[] { "peng", "zhao", "li" };
		Arrays.sort(datas, (v1, v2) -> Integer.compare(v1.length(), v2.length()));
		Stream.of(datas).forEach(param -> System.out.println(param));
	}
}
