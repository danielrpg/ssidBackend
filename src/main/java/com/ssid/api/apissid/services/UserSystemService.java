package com.ssid.api.apissid.services;

/**
 * @author Borisytu
 */
import com.ssid.api.apissid.domain.UserSystem;
import java.util.List;

public interface UserSystemService {
    List<UserSystem> getAllUsers();

    void saveUser(UserSystem user);

    UserSystem findByUserName(String userName);
}
