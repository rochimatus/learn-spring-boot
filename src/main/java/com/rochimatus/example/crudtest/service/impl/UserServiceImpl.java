package com.rochimatus.example.crudtest.service.impl;

import com.rochimatus.example.crudtest.model.controller.request.CreateUserRequest;
import com.rochimatus.example.crudtest.model.controller.request.UpdateUserRequest;
import com.rochimatus.example.crudtest.model.database.User;
import com.rochimatus.example.crudtest.repository.UserRepository;
import com.rochimatus.example.crudtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(CreateUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepository.save(user);
    }

    @Override
    public void update(Integer id, UpdateUserRequest request) {
        User user = findById(id);
        user.setPassword(request.getPassword());
        userRepository.save(user);
    }

    @Override
    public List<User> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userRepository.findAll(pageRequest)
                .getContent();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
