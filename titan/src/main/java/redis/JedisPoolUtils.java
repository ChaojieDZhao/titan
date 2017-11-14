package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        InputStream inputStream = JedisPoolUtils.class.getClassLoader()
                .getResourceAsStream("redisConfig.properties");
        Properties pro = new Properties();
        try {
            pro.load(inputStream);
            JedisPoolConfig jedisConfig = new JedisPoolConfig();
            jedisConfig.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
            jedisConfig.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));
            jedisConfig.setMaxWaitMillis(Integer.parseInt(pro.getProperty("maxWaitMillis")));
            jedisConfig.setNumTestsPerEvictionRun(Integer.parseInt(pro.getProperty("numTestsPerEvictionRun")));
            jedisConfig.setTestWhileIdle(Boolean.valueOf(pro.getProperty("testWhileIdle")));
            jedisConfig.setTimeBetweenEvictionRunsMillis(
                    Integer.parseInt(pro.getProperty("timeBetweenEvictionRunsMillis")));
            jedisConfig.setTestOnBorrow(Boolean.valueOf(pro.getProperty("testOnBorrow").toString()));
            jedisConfig.setTestOnReturn(Boolean.valueOf(pro.getProperty("testOnReturn").toString()));
            jedisPool = new JedisPool(jedisConfig, pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")),
                    Integer.parseInt(pro.getProperty("timeout")), pro.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pro.clear();
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static JedisPool getJedisPool() {
        return jedisPool;
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void close(Jedis jedis) {
        jedis.close();
    }
}
