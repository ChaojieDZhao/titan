package redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Test1 上午11:54:44
 * <p>
 * Copyright zhaocj Inc. All rights reserved. Love ME Like Justin Bieber.
 */
public class Test1 {
    Jedis redis = JedisPoolUtils.getJedis();

    @Test
    public void test1() throws Exception {
        while (true) {
            String Clients = redis.info("Clients");
            String stats = redis.info("stats");
            System.out.println("客户端连接信息 ：    " + Clients);
            System.out.println("服务端状态信息：    " + stats);
            Thread.sleep(3000);
        }
    }

}
