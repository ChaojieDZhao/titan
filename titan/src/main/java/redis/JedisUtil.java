package redis;

import redis.clients.jedis.Jedis;

/**
 * 
 * JedisUtil.java 2016-7-11
 * 
 * Copyright zhaocj Inc. All rights reserved. Love Me Like Love Justin Bieber
 * 位图法工具用来记录那段时间登录过的用户的的个数
 */

public class JedisUtil {

	/**
	 * 保存登陆用户的会话ID 类似于浏览器的sessionID   EXPIRE的单位为秒
	 */
	public static void keepSessionIDForApp(String sign, String userID, Integer database) {
		Jedis redis = JedisPoolUtils.getJedis();
		redis.select(database);
		try {
			redis.set(sign, userID);
			redis.expire(sign, 60 * 60 * 48);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JedisPoolUtils.close(redis);
		}
	}
	/**
	 * 
	 * @param sign
	 *            用户的sessionID
	 * @param database
	 *            那个数据库中取值
	 * @return
	 */
	public static String getSessionIDForApp(String sign, Integer database) {
		Jedis redis = JedisPoolUtils.getJedis();
		redis.select(database);
		String sessionID = null;
		try {
			sessionID = redis.get(sign);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JedisPoolUtils.close(redis);
		}
		return sessionID;
	}
	/**
	 * 
	 * @param sessionID
	 * @param database
	 */
	public static void removeSessionID(String sessionID, Integer database) {
		Jedis redis = JedisPoolUtils.getJedis();
		redis.select(database);
		try {
			redis.del(sessionID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JedisPoolUtils.close(redis);
		}
	}

	public static void main(String[] args) {
	}
}