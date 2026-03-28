package com.iuh.student.partition_demo.service;

import com.iuh.student.partition_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(User user) {
        // LOGIC: Horizontal Partitioning
        // Condition: Nam -> table_user_01, Nữ -> table_user_02
        String tableName = user.getGender().equalsIgnoreCase("nam") 
                           ? "table_user_01" 
                           : "table_user_02";

        String sql = "INSERT INTO " + tableName + " (id, name, gender) VALUES (?, ?, ?)";
        
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getGender());
        System.out.println(">>> Đã ghi vào MariaDB phân vùng: " + tableName);
    }
}