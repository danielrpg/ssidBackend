package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.UserSystem;
import com.ssid.api.apissid.services.UserSystemService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author daniel fernandez
 */
@RestController
public class UserController {

    private UserSystemService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserSystemService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * This method allow to create a new user if you want other user
     * @param user
     */
    @RequestMapping(value = ApiPath.USER_PATH, method = RequestMethod.POST)
    public void saveUser(@RequestBody UserSystem user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
    }

    @RequestMapping(value = ApiPath.USER_PATH, method = RequestMethod.GET)
    public List<UserSystem> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = ApiPath.USER_BY_USERNAME, method = RequestMethod.GET)
    public UserSystem getUser(@PathVariable String username) {
        return userService.findByUserName(username);
    }


}
