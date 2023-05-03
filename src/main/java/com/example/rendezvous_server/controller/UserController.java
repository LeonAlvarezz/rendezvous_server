package com.example.rendezvous_server.controller;

import com.example.rendezvous_server.model.User;
import com.example.rendezvous_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("user/get")
    public List<User> getAllUser()
    {
        return userService.getAllUser();
    }
}
