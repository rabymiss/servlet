package com.example.servlet.repository;

import com.example.servlet.entity.User;

public interface UserRepository {

    public int save(User user);

    public Long findUser(String username, String password);

}
