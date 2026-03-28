package com.iuh.student.service;

import com.iuh.student.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void processOrder(Order order) {
        // Logic Horizontal Partitioning: Tách đơn hàng đang giao và đơn đã xong
        String targetTable = order.getStatus().equalsIgnoreCase("DELIVERING") 
                             ? "orders_active" : "orders_history";

        String sql = "INSERT INTO " + targetTable + " (id, customer_name, total_price, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getId(), order.getCustomerName(), order.getTotalPrice(), order.getStatus());
        
        System.out.println(">>> [Hệ thống Food] Đã ghi vào phân vùng: " + targetTable);
    }
}