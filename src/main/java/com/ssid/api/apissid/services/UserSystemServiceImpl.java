package com.ssid.api.apissid.services;
/**
 * @author Borisytu
 */
import com.ssid.api.apissid.domain.UserSystem;
import com.ssid.api.apissid.repositories.UserSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserSystemServiceImpl implements UserSystemService {

    private UserSystemRepository userSystemRepository;

    @Autowired
    public UserSystemServiceImpl(UserSystemRepository userSystemRepository) {
        this.userSystemRepository = userSystemRepository;
    }

    @Override
    public List<UserSystem> getAllUsers() {
        return  userSystemRepository.findAll();
    }

}
