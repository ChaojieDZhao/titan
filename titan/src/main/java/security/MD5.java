package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

/**
 * 
 * MD5 下午1:58:30 Copyright zhaocj Inc. All rights reserved. Love Me Like Love
 * Justin Bieber
 * 
 */
public class MD5 {
	public static String md5(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			return new String(digest.digest(str.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Test
	public void test1() {
		String key = "alldios";
		System.out.println("MD5加密： " + MD5.md5(key));
	}
}
