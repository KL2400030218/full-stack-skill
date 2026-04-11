package com.fsad.skill15.repository;

import com.fsad.skill15.model.AppUser;
import com.fsad.skill15.model.Role;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final Map<String, AppUser> users = new ConcurrentHashMap<>();

    public UserRepository() {
        users.put("admin", new AppUser(1L, "admin", "admin123", Role.ADMIN));
        users.put("employee", new AppUser(2L, "employee", "employee123", Role.EMPLOYEE));
    }

    public Optional<AppUser> findByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }
}
