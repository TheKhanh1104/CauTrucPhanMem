import redis.clients.jedis.UnifiedJedis;
import utils.JedisUtil;

import java.util.Scanner;

public class ServiceSender {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try(UnifiedJedis jedis = JedisUtil.getInstance().getJedis()) {
            while (true) {
                System.out.print("> ");
                String input = sc.nextLine();

                if ("exit".equalsIgnoreCase(input)) {
                    System.out.println("Kết thúc service gửi");
                    break;
                }

                jedis.lpush("demo-queue", input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
