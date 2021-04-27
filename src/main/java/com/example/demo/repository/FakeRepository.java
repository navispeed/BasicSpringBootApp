package com.example.demo.repository;

import com.example.demo.model.User;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FakeRepository {

    List<User> users;

    public List<User> findAll() {
        return users;
    }

    public void put(User user) {
        this.users.add(user);
    }

}
