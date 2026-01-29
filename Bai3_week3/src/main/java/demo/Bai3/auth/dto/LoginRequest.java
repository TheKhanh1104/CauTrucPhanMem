package demo.Bai3.auth.dto;

public class LoginRequest {
    private String username;
    private String password;

    // Phải có constructor trống
    public LoginRequest() {}

    // Getter và Setter viết tay (Để AuthController hết lỗi)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}