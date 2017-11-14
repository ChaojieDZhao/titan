package security;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Base64 下午1:46:20 Copyright zhaocj Inc. All rights reserved. Love Me Like Love
 * Justin Bieber
 */
public class Base64 {
    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    @Test
    public void test1() throws Exception {
        String key = "alldios";
        String encryptBASE64 = Base64.encryptBASE64(key.getBytes());
        System.out.println("加密  " + encryptBASE64);
        byte[] decryptBASE64 = Base64.decryptBASE64(encryptBASE64);
        System.out.println("解密  " + new String(decryptBASE64));
    }
}
