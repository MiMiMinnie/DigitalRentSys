package com.south.service.impl;

import com.south.repository.AdminRepository;
import com.south.repository.UserRepository;
import com.south.repository.impl.AdminRepositoryImpl;
import com.south.repository.impl.UserRepositoryImpl;
import com.south.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository = new UserRepositoryImpl();
    private AdminRepository adminRepository = new AdminRepositoryImpl();

    @Override
    public Object login(String username, String password,String type) {
        Object object = null ;
        switch (type){
            case "user":
                object = userRepository.login(username,password);
                break;
            case "admin":
                object = adminRepository.login(username,password);
                break;
        }
        return object;
    }
}
