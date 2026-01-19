package services;

import redis.clients.jedis.UnifiedJedis;
import utils.JedisUtil;

public class EmailService {
    private final UnifiedJedis jedis = JedisUtil.getInstance().getJedis();

    public void send(String orderId) {
        String email = jedis.hget("order:" + orderId, "email");

        System.out.println("[EMAIL] Sending email to " + email +
                " for order " + orderId);

        try {
            Thread.sleep(2000);

            jedis.hset("order:" + orderId, "status", "EMAIL_SENT");
            System.out.println("[EMAIL] Email sent for order " + orderId);
        } catch (Exception e) {
            jedis.hset("order:" + orderId, "status", "EMAIL_FAILED");
            e.printStackTrace();
        }
    }
}
