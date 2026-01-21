interface Payment {
    void process();
}

class MomoPayment implements Payment {
    public void process() { System.out.println("Đang xử lý thanh toán qua ví MOMO..."); }
}

class CardPayment implements Payment {
    public void process() { System.out.println("Đang xử lý thanh toán qua THẺ TÍN DỤNG..."); }
}

class PaymentFactory {
    public static Payment getPaymentMethod(String type) {
        if (type.equalsIgnoreCase("MOMO")) return new MomoPayment();
        if (type.equalsIgnoreCase("CARD")) return new CardPayment();
        return null;
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        Payment method1 = PaymentFactory.getPaymentMethod("MOMO");
        method1.process();

        Payment method2 = PaymentFactory.getPaymentMethod("CARD");
        method2.process();
    }
}