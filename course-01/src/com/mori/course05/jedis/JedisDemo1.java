package com.mori.course05.jedis;

import com.mori.course05.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisDemo1 {
    /**
     * Jedis 快速入门
     */
    @Test
    public void test01() {
        //1、获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2、操作
        jedis.set("username", "lisi"); //存string类型数据
        //3、关闭连接
        jedis.close();
    }

    @Test
    public void test02() {
        Jedis jedis = new Jedis(); //空参构造，默认localhost 6379

        System.out.println("-----string-----");
        jedis.set("username", "zhangsan"); //存string类型数据
        String username = jedis.get("username");
        System.out.println(username);
        //setex()可以保存键值对，并指定键值对的过期时间
        jedis.setex("activecode", 20, "acode"); //(activecode,acode)这个键值对存入redis，20秒后自动删除

        System.out.println("-----hash-----");
        jedis.hset("user", "name", "AAA");
        jedis.hset("user", "age", "12");
        jedis.hset("user", "gender", "male");
        jedis.hset("user", "key", "val");
        jedis.hdel("user", "key");
        String name = jedis.hget("user", "name");
        System.out.println(name);
        Map<String, String> myhash = jedis.hgetAll("user");
        System.out.println(myhash);

        System.out.println("-----list-----");
        jedis.del("mylist");
        jedis.lpush("mylist", "A", "B", "C");
        jedis.rpush("mylist", "A");
        jedis.rpush("mylist", "D");
        jedis.lpop("mylist");
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        System.out.println("-----set-----");
        jedis.sadd("myset", "A", "B", "C");
        jedis.sadd("myset", "D");
        jedis.srem("myset", "C");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        System.out.println("-----sortedset-----");
        jedis.zadd("mysort", 50, "A");
        jedis.zadd("mysort", 10, "B");
        jedis.zadd("mysort", 100, "C");
        jedis.zadd("mysort", 65, "D");
        jedis.zrem("mysort", "D");
        Set<String> mysort = jedis.zrange("mysort", 0, -1);
        System.out.println(mysort);

        jedis.close();
    }

    /**
     * Jedis 连接池
     */
    @Test
    public void test03() {
        //0、创建一个配置对象 JedisPoolConfig
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50); //最大连接数
        config.setMaxIdle(10); //最大空闲连接

        //1、创建 Jedis 连接池 对象
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
        //2、获取Jedis连接
        Jedis jedis = jedisPool.getResource();
        jedis.set("qq", "222");
        System.out.println(jedis.get("qq"));
        //3、释放归还连接 close()
        jedis.close();
    }

    /**
     * JedisPool 工具类
     */
    @Test
    public void test04() {
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("chart", "aa");
        System.out.println(jedis.get("chart"));
        JedisPoolUtils.closeJedis(jedis);
    }
}
