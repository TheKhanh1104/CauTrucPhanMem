interface Notifier {
    void send(String message);
}

class BaseAppNotifier implements Notifier {
    public void send(String message) { System.out.println("[App] Gửi thông báo: " + message); }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrapped;
    public NotifierDecorator(Notifier n) { this.wrapped = n; }
    public void send(String message) { wrapped.send(message); }
}

class SMSDecorator extends NotifierDecorator {
    public SMSDecorator(Notifier n) { super(n); }
    public void send(String message) {
        super.send(message);
        System.out.println("[SMS] Gửi mã xác thực kèm theo: " + message);
    }
}

class EmailDecorator extends NotifierDecorator {
    public EmailDecorator(Notifier n) { super(n); }
    public void send(String message) {
        super.send(message);
        System.out.println("[Email] Gửi hóa đơn chi tiết: " + message);
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("--- Trường hợp 1: Chỉ App ---");
        Notifier simple = new BaseAppNotifier();
        simple.send("Số dư của bạn đã thay đổi.");

        System.out.println("\n--- Trường hợp 2: App + SMS + Email ---");
        Notifier fullOptions = new EmailDecorator(new SMSDecorator(new BaseAppNotifier()));
        fullOptions.send("Giao dịch 500k thành công.");
    }
}