package com.ssid.api.apissid.services;

/**
 * @author Borisytu
 */
import com.ssid.api.apissid.domain.UserSystem;
import java.util.List;
import java.util.Optional;

public interface UserSystemService {
    List<UserSystem> getAllUsers();

    void saveUser(UserSystem user);

    UserSystem findByUserName(String userName);
    
    Optional<UserSystem> findUserById(Long idUser);
}
