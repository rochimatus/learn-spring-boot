package com.rochimatus.example.crudtest.repository;


import com.rochimatus.example.crudtest.model.database.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
