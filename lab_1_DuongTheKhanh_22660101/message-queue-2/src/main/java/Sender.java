import services.OrderService;

import java.util.Scanner;

public class Sender {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("[SENDER] Enter customer email (type 'exit' to quit)");

        while (true) {
            System.out.print("[SENDER] > ");
            String email = scanner.nextLine();

            if ("exit".equalsIgnoreCase(email)) {
                System.out.println("[SENDER] Shutdown");
                break;
            }

            orderService.create(email);
            System.out.println("[SENDER] API response returned to user\n");
        }
    }
}
