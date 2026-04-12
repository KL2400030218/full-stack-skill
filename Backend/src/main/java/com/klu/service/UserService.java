package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.User;
import com.klu.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // register user
    public User register(User user) {
        return repo.save(user);
    }

    // login logic
    public User login(String username, String password) {

        User user = repo.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    // get user details
    public User getUser(String username) {
        return repo.findByUsername(username);
    }
}