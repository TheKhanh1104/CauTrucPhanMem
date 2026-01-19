package utils;

import redis.clients.jedis.UnifiedJedis;

public class JedisUtil {
    private static JedisUtil instance;
    private UnifiedJedis jedis;

    private JedisUtil() {
        this.jedis = new UnifiedJedis("redis://localhost:6379");
    }

    public static synchronized JedisUtil getInstance() {
        if (instance == null) {
            instance = new JedisUtil();
        }
        return instance;
    }

    public UnifiedJedis getJedis() {
        return jedis;
    }
}

