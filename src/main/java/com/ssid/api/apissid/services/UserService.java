package com.ssid.api.apissid.services;

/**
 * @author Borisytu
 */

import com.ssid.api.apissid.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
}
