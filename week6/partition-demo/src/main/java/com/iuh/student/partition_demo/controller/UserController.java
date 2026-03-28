package com.iuh.student.partition_demo.controller;

import com.iuh.student.partition_demo.model.User;
import com.iuh.student.partition_demo.service.UserService ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/partition")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String save(@RequestBody User user) {
        userService.insertUser(user);
        return "Success!";
    }
}