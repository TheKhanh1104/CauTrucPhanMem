package com.iuh.student.model;
import lombok.Data;

@Data
public class Order {
    private int id;
    private String customerName;
    private double totalPrice;
    private String status; // "DELIVERING" hoặc "COMPLETED"
}