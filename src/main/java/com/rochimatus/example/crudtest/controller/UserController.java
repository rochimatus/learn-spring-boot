package com.rochimatus.example.crudtest.controller;


import com.rochimatus.example.crudtest.model.controller.request.CreateUserRequest;
import com.rochimatus.example.crudtest.model.controller.request.UpdateUserRequest;
import com.rochimatus.example.crudtest.model.database.User;
import com.rochimatus.example.crudtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateUserRequest request) {
        userService.create(request);
    }

    @PutMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody UpdateUserRequest request) {
        userService.update(id, request);
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int size) {
        return userService.findAll(page, size);
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @DeleteMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
