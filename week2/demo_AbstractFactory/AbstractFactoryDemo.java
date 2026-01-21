// 1. Định nghĩa các interface cho từng sản phẩm trong họ
interface Button { void paint(); }
interface Checkbox { void paint(); }

// 2. Các sản phẩm cụ thể cho Windows
class WindowsButton implements Button {
    public void paint() { System.out.println("Vẽ nút bấm phong cách Windows."); }
}
class WindowsCheckbox implements Checkbox {
    public void paint() { System.out.println("Vẽ Checkbox phong cách Windows."); }
}

// 3. Các sản phẩm cụ thể cho Mac
class MacButton implements Button {
    public void paint() { System.out.println("Vẽ nút bấm phong cách Mac."); }
}
class MacCheckbox implements Checkbox {
    public void paint() { System.out.println("Vẽ Checkbox phong cách Mac."); }
}

// 4. Interface Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// 5. Các nhà máy cụ thể (Concrete Factories)
class WindowsFactory implements GUIFactory {
    public Button createButton() { return new WindowsButton(); }
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}

class MacFactory implements GUIFactory {
    public Button createButton() { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

// 6. Demo Class (Nhớ xóa 'package ...' nếu bạn chạy file đơn lẻ)
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        GUIFactory factory;
        
        // Giả sử hệ thống phát hiện đang chạy trên Mac
        System.out.println("--- Khởi tạo giao diện Mac ---");
        factory = new MacFactory();
        factory.createButton().paint();
        factory.createCheckbox().paint();

        // Giả sử đổi sang Windows
        System.out.println("\n--- Khởi tạo giao diện Windows ---");
        factory = new WindowsFactory();
        factory.createButton().paint();
        factory.createCheckbox().paint();
    }
}