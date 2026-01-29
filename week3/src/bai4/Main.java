package bai4;
public class Main {
    public static void main(String[] args) {
        Library lib = Library.getInstance();

        // 1. Đăng ký thông báo (Observer)
        lib.addObserver(msg -> System.out.println("[Thông báo]: " + msg));

        // 2. Thêm sách qua Factory
        BookFactory factory = new PaperBookFactory();
        Book b1 = factory.createBook("Design Patterns");
        lib.addBook(b1);

        // 3. Tìm kiếm bằng Strategy
        lib.setSearchStrategy(new SearchByTitle());
        System.out.println("--- Kết quả tìm kiếm ---");
        lib.performSearch("Design Patterns");

        // 4. Mượn sách với Decorator
        Borrowing myBorrow = new BasicBorrowing(b1);
        myBorrow = new ExtraTimeDecorator(myBorrow); // Thêm tính năng gia hạn
        
        System.out.println("--- Chi tiết mượn sách ---");
        System.out.println(myBorrow.getDetails());
        System.out.println("Tổng phí: " + myBorrow.getCost() + " VNĐ");
    }
}