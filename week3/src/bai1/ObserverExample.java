package bai1;
import java.util.ArrayList;
import java.util.List;

// 1. Giao diện Người quan sát
interface Observer {
    void update(String message);
}

// 2. Lớp Quản lý thông báo (Subject)
class NotificationSystem {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// 3. Lớp Cổ phiếu (Cụ thể hóa Subject)
class Stock extends NotificationSystem {
    private String name;

    public Stock(String name) { this.name = name; }

    public void updatePrice(double newPrice) {
        System.out.println("\n[Hệ thống] Giá cổ phiếu " + name + " đổi thành: " + newPrice);
        notifyAllObservers("Cổ phiếu " + name + " hiện có giá mới là " + newPrice);
    }
}

// 4. Lớp Nhà đầu tư (Cụ thể hóa Observer)
class Investor implements Observer {
    private String name;
    public Investor(String name) { this.name = name; }

    @Override
    public void update(String message) {
        System.out.println("Gửi mail cho " + name + ": " + message);
    }
}

// --- Main để chạy thử ---
public class ObserverExample {
    public static void main(String[] args) {
        Stock apple = new Stock("AAPL");
        
        Investor inv1 = new Investor("Nguyễn Văn A");
        Investor inv2 = new Investor("Trần Thị B");

        apple.subscribe(inv1);
        apple.subscribe(inv2);

        apple.updatePrice(180.50);
    }
}