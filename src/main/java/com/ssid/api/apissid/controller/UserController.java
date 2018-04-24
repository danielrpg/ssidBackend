package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daniel fernandez
 */
@RestController
public class UserController {

    @GetMapping(path = ApiPath.USER_PATH)
    private String getUser(){
        return "List user";
    }


}
