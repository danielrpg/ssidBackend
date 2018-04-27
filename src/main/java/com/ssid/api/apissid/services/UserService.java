package com.ssid.api.apissid.services;

/**
 * @author Borisytu
 */

import com.ssid.api.apissid.domain.UserSystem;

import java.util.List;

public interface UserService {
    List<UserSystem> getAllUsers();
}
