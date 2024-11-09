package com.sprk.many_to_many.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprk.many_to_many.dto.UserDto;
import com.sprk.many_to_many.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }


    @GetMapping("/getUserById/{userId}")
    public UserDto getUserById(@PathVariable int userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers(){

        return userService.getAllUsers();
    }

    @GetMapping("/getUserByEmail")
    public UserDto getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable int userId){
        return userService.deleteUser(userId);
    }

    @PutMapping("/updateUserDetails/{userId}")
    public String updateUserDetails(@RequestBody UserDto userDto, @PathVariable int userId){
        return userService.updateUserById(userId,userDto);
    }
}
