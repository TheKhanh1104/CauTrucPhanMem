class DatabasePool {
    private static DatabasePool instance;

    // Private constructor ngăn khởi tạo từ bên ngoài
    private DatabasePool() {
        System.out.println("--- Khởi tạo Database Connection Pool (Duy nhất) ---");
    }

    // Thread-safe Singleton
    public static synchronized DatabasePool getInstance() {
        if (instance == null) {
            instance = new DatabasePool();
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Đang thực thi truy vấn: " + sql);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        DatabasePool pool1 = DatabasePool.getInstance();
        DatabasePool pool2 = DatabasePool.getInstance();

        pool1.query("SELECT * FROM users");

        // Kiểm tra xem pool1 và pool2 có phải là một không
        System.out.println("Cùng một thực thể? " + (pool1 == pool2));
    }
}