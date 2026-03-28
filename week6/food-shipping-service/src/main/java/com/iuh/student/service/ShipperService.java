package com.iuh.student.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShipperService {
    @Autowired private JdbcTemplate jdbcTemplate;
    public void assignTask(int id, String name, String area) {
        // MariaDB sẽ tự động đưa vào Partition dựa trên cột 'area'
        jdbcTemplate.update("INSERT INTO shipper_tasks VALUES (?, ?, ?)", id, name, area);
    }
}