package com.south.repository;

import com.south.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);
}
