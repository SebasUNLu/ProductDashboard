package com.example.productDashboard.controllers;

import com.example.productDashboard.Entities.User;
import com.example.productDashboard.Services.UserDTO;
import com.example.productDashboard.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUser(id);
    }

    @GetMapping("/user")
    public List<User> getUser() {
        return service.getUsers();
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User updateUser) {
        return service.updateUser(updateUser);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody User user){
        return service.login(user.getEmail(), user.getPassword());
    }

}
