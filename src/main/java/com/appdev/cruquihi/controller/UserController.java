package com.appdev.cruquihi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appdev.cruquihi.entity.UserEntity;
import com.appdev.cruquihi.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService sserv;

    // CREATE
    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity user) {
        return sserv.createUser(user);
    }

    // READ ALL
    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return sserv.getAllUsers();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable int id) {
        return sserv.getUserById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public UserEntity updateUser(@RequestParam int id, @RequestBody UserEntity newUserDetails) {
        return sserv.updateUser(id, newUserDetails);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        sserv.deleteUser(id);
        return "User with ID " + id + " has been deleted.";
    }
}