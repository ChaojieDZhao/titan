package lambda;

import java.util.concurrent.TimeUnit;

/**
 * 
 * Test1 下午3:57:44
 * 
 * Copyright zhaocj Inc. All rights reserved. Love ME Like Justin Bieber.
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello World!");
			}
		}).start();
		TimeUnit.SECONDS.sleep(10);
	}
}
