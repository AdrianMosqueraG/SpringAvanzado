package com.example.EJS31.JWT.service;

import com.example.EJS31.JWT.domain.Role;
import com.example.EJS31.JWT.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();

}
