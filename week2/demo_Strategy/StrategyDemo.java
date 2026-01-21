interface ShippingStrategy {
    double calculate(double weight);
}

class FastShipping implements ShippingStrategy {
    public double calculate(double weight) { return weight * 5000; }
}

class StandardShipping implements ShippingStrategy {
    public double calculate(double weight) { return weight * 2000; }
}

class Order {
    private ShippingStrategy strategy;
    public void setShippingMethod(ShippingStrategy strategy) { this.strategy = strategy; }
    public void calculatePrice(double weight) {
        System.out.println("Tổng phí vận chuyển: " + strategy.calculate(weight) + " VNĐ");
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        Order order = new Order();
        
        System.out.print("Chọn Giao hàng nhanh: ");
        order.setShippingMethod(new FastShipping());
        order.calculatePrice(2.5);

        System.out.print("Chọn Giao hàng tiết kiệm: ");
        order.setShippingMethod(new StandardShipping());
        order.calculatePrice(2.5);
    }
}