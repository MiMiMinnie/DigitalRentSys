package com.south.repository;

import com.south.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
