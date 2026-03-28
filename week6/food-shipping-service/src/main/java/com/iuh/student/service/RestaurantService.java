package com.iuh.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired private JdbcTemplate jdbcTemplate;
    public void addFood(int id, String name, double price, String desc) {
        // Ghi vào 2 bảng khác nhau (Vertical Partitioning)
        jdbcTemplate.update("INSERT INTO food_basic VALUES (?, ?, ?)", id, name, price);
        jdbcTemplate.update("INSERT INTO food_details (food_id, description) VALUES (?, ?)", id, desc);
    }
}

