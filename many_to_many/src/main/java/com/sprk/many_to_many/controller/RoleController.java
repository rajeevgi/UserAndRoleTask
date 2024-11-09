package com.sprk.many_to_many.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprk.many_to_many.dto.RoleDto;
import com.sprk.many_to_many.service.RoleService;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;
    
    @PostMapping("/saveRole")
    public RoleDto saveRole(@RequestBody RoleDto roleDto){
        return roleService.saveRole(roleDto);
    }

    @GetMapping("/getRoleById/{roleId}")
    public RoleDto getRoleById(@PathVariable int roleId){
        return roleService.getRoleById(roleId);
    }

    @GetMapping("/getAllRoles")
    public List<RoleDto> getAllRoles(){
        return roleService.getAllRoles();
    }

    @DeleteMapping("/deleteRole/{roleId}")
    public String deleteRoleById(@PathVariable int roleId){
        return roleService.deleteRoleById(roleId);
    }
}
