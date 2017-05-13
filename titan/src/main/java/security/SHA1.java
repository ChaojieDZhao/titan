package security;

import java.security.MessageDigest;

import org.junit.Test;

/**
 * 
 * SHA1 下午2:02:01 Copyright zhaocj Inc. All rights reserved. Love Me Like Love
 * Justin Bieber
 * 
 */
public class SHA1 {
	public static byte[] sha1ToBytes(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			byte[] bts = digest.digest(str.getBytes());
			return bts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Test
	public void test() {
		String key = "alldios";
		System.out.println("sha1加密： " + SHA1.sha1ToBytes(key));
	}
}
