package com.mori.course05.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JedisPool 工具类
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool;

    static {
        try {
            ClassLoader classLoader = JedisPoolUtils.class.getClassLoader();
            InputStream is = classLoader.getResourceAsStream("jedis.properties");//相对于src的路径
            Properties prop = new Properties();
            prop.load(is);

            String host = prop.getProperty("host");
            int port = Integer.parseInt(prop.getProperty("port"));
            int maxTotal = Integer.parseInt(prop.getProperty("maxTotal"));
            int maxIdle = Integer.parseInt(prop.getProperty("maxIdle"));

            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(maxTotal);
            config.setMaxIdle(maxIdle);
            jedisPool = new JedisPool(config, host, port);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void closeJedis(Jedis jedis) {
        jedis.close();
    }
}
