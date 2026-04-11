package com.fsad.skill15.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SecureController {

    @PostMapping("/admin/add")
    public ResponseEntity<Map<String, String>> addEmployee() {
        return ResponseEntity.ok(Map.of("message", "ADMIN authorized: add operation successful"));
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity<Map<String, String>> deleteEmployee() {
        return ResponseEntity.ok(Map.of("message", "ADMIN authorized: delete operation successful"));
    }

    @GetMapping("/employee/profile")
    public ResponseEntity<Map<String, String>> employeeProfile(Authentication authentication) {
        return ResponseEntity.ok(Map.of(
                "message", "Profile fetched successfully",
                "username", authentication.getName()
        ));
    }
}
