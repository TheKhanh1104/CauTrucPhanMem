interface TransactionState {
    void next(TransactionContext context);
    void printStatus();
}

class PendingState implements TransactionState {
    public void next(TransactionContext context) { context.setState(new SuccessState()); }
    public void printStatus() { System.out.println("Trạng thái: Đang chờ xử lý."); }
}

class SuccessState implements TransactionState {
    public void next(TransactionContext context) { System.out.println("Giao dịch đã hoàn tất, không thể chuyển tiếp."); }
    public void printStatus() { System.out.println("Trạng thái: Thanh toán thành công!"); }
}

class TransactionContext {
    private TransactionState state = new PendingState();
    public void setState(TransactionState state) { this.state = state; }
    public void nextState() { state.next(this); }
    public void showStatus() { state.printStatus(); }
}

public class StateDemo {
    public static void main(String[] args) {
        TransactionContext tx = new TransactionContext();
        tx.showStatus(); // Đang chờ
        tx.nextState();  // Chuyển sang thành công
        tx.showStatus(); // Thành công
    }
}