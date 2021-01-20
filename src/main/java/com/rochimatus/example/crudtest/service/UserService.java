package com.rochimatus.example.crudtest.service;

import com.rochimatus.example.crudtest.model.controller.request.CreateUserRequest;
import com.rochimatus.example.crudtest.model.controller.request.UpdateUserRequest;
import com.rochimatus.example.crudtest.model.database.User;

import java.util.List;

public interface UserService {

    void create(CreateUserRequest request);

    void update(Integer id, UpdateUserRequest request);

    List<User> findAll(int page, int size);

    User findById(Integer id);

    void delete(Integer id);
}
