package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.UserSystem;
import com.ssid.api.apissid.services.SPSerives.SPUserService;
import com.ssid.api.apissid.services.UserSystemService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author daniel fernandez
 */
@RestController
public class UserController {


    private SPUserService spUserService;
    private UserSystemService userSystemService;

    public UserController(SPUserService spUserService, UserSystemService userSystemService) {
        this.spUserService = spUserService;
        this.userSystemService = userSystemService;
    }

    @RequestMapping(value = ApiPath.USER_PATH, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody UserSystem user) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("success", this.spUserService.createUser(user));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = ApiPath.USER_PATH + "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable("id") Long idUser, @RequestBody UserSystem user){
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("success", this.spUserService.updateUser(idUser, user));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = ApiPath.USER_PATH, method = RequestMethod.GET)
    public List<UserSystem> getAllUsers() {
       return this.spUserService.getAllUsers();
    }

    @RequestMapping(value =ApiPath.USER_PATH + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable("id") Long idUser){
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("success", this.spUserService.deleteUser(idUser));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = ApiPath.USER_PATH + "/{id}", method = RequestMethod.GET)
    public Optional<UserSystem> getUserById(@PathVariable("id") Long idUser) {
       return this.userSystemService.findUserById(idUser);
    }	

}
