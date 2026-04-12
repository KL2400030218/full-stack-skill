package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.User;
import com.klu.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // allow React
public class UserController {

    @Autowired
    private UserService service;

    // REGISTER API
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    // LOGIN API
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return service.login(user.getUsername(), user.getPassword());
    }

    // GET USER
    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return service.getUser(username);
    }
}