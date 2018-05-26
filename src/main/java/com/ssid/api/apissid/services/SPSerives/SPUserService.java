package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.UserSystem;

import java.util.List;

public interface SPUserService {

    List<UserSystem> getAllUsers();

    Boolean deleteUser(Long idUser);

    Boolean createUser(UserSystem userSystem);

    UserSystem updateUser(Long idUser, UserSystem userSystem);
}
