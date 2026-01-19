import redis.clients.jedis.UnifiedJedis;
import utils.JedisUtil;

import java.time.LocalDate;
import java.util.List;

public class ServiceReceiver {
    public static void main(String[] args) {
        try(UnifiedJedis jedis = JedisUtil.getInstance().getJedis()) {
            System.out.println("Service 2 is waiting for events...");

            while (true) {
                List<String> result = jedis.blpop(0, "demo-queue");
                String message = result.get(1);

                System.out.println(LocalDate.now() + ": " + message);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
