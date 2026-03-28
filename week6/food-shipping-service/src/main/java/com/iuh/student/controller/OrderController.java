package com.iuh.student.controller;

import com.iuh.student.model.Order;
import com.iuh.student.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

  @PostMapping("/create")
public String createOrder(
    @RequestParam("customerName") String customerName, 
    @RequestParam("status") String status
) {
    Order order = new Order();
    order.setCustomerName(customerName);
    order.setStatus(status);
    order.setId((int)(Math.random() * 1000)); // Tạo ID ngẫu nhiên để test

    orderService.processOrder(order);
    
    return "Đặt hàng thành công cho: " + customerName + " (Đã phân vùng vào bảng " 
            + (status.equalsIgnoreCase("DELIVERING") ? "orders_active" : "orders_history") + ")";
}
}