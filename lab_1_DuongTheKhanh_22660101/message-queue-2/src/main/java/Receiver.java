import redis.clients.jedis.UnifiedJedis;
import services.EmailService;
import utils.JedisUtil;

import java.util.List;

public class Receiver {

    public static void main(String[] args) {
        UnifiedJedis jedis = JedisUtil.getInstance().getJedis();
        EmailService emailService = new EmailService();

        System.out.println("[RECEIVER] Email worker started, waiting for jobs...");

        while (true) {
            List<String> result = jedis.blpop(0, "email-job-queue");
            String orderId = result.get(1);

            System.out.println("[RECEIVER] Got job for order: " + orderId);
            emailService.send(orderId);
        }
    }
}
