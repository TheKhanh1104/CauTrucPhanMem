package services;

import redis.clients.jedis.UnifiedJedis;
import utils.JedisUtil;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OrderService {
    private final UnifiedJedis jedis = JedisUtil.getInstance().getJedis();

    public String create(String email) {
        String orderId = UUID.randomUUID().toString();
        Map<String, String> order = new HashMap<>();
        order.put("email", email);
        order.put("status", "CREATED");
        order.put("createdAt", LocalDateTime.now().toString());

        jedis.hset("order:" + orderId, order);

        jedis.lpush("email-job-queue", orderId);
        jedis.hset("order:" + orderId, "status", "EMAIL_PENDING");

        System.out.println("[ORDER] Email job queued for order: " + orderId);
        return orderId;
    }
}
