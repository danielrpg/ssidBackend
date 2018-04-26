package com.ssid.api.apissid.services;

/**
 * @author Borisytu
 */

import com.ssid.api.apissid.domain.UserSystem;
import com.ssid.api.apissid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserSystem> getAllUsers() {
        return  userRepository.findAll();
    }

}
