package com.sprk.many_to_many.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprk.many_to_many.dto.UserWithRoleDto;
import com.sprk.many_to_many.service.AdminService;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/assign_role_to_user")
    public String addRoleToUser(@RequestParam int userId, @RequestParam int roleId){

        return adminService.addRoleToUser(userId, roleId);
    }

    @GetMapping("/get_user_with_role/{userId}")
    public UserWithRoleDto getUserWithRoleById(@PathVariable int userId){
        return adminService.getUserWithRoleById(userId);
    }

    @GetMapping("/getUserByRoleId/{roleId}")
    public ResponseEntity<?> getUserByRoleId(@PathVariable int roleId){
        return adminService.getUserByRoleId(roleId);
    }

    @DeleteMapping("/deleteRoleForUser")
    public String deleteRoleFromUser(@RequestParam int userId, @RequestParam int roleId){
        return adminService.deleteRoleFromUser(userId, roleId);
    }

}
