package com.sprk.many_to_many.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprk.many_to_many.dto.UserWithRoleDto;
import com.sprk.many_to_many.entity.Role;
import com.sprk.many_to_many.entity.User;
import com.sprk.many_to_many.mapper.UserMapper;
import com.sprk.many_to_many.repository.RoleRepository;
import com.sprk.many_to_many.repository.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // Post/save mapping to assign role to user
    public String addRoleToUser(int userId, int roleId) {
        
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found."));

        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found."));

        user.addRole(role);  // maintain the bi-directional association
        userRepository.save(user);

        return "Role assign to user successfully....";
    }

    // Get mapping to get user with role by userId
    public UserWithRoleDto getUserWithRoleById(int userId) {
        
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: "+userId));

        UserWithRoleDto userWithRoleDto = UserMapper.mappedUserToUserWithRoleDto(user, new UserWithRoleDto());

        return userWithRoleDto;
    }

    // Get mapping to get user with roleId
    public ResponseEntity<?> getUserByRoleId(int roleId) {
        
        List<User> users = userRepository.findByRoleId(roleId);
        
        if(users.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found with roleId: "+roleId);
        }

        return ResponseEntity.ok(users);
    }

    // Delete mapping to remove role from user
    public String deleteRoleFromUser(int userId, int roleId) {
        
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found."));

        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found."));

        if(user.getRoles().contains(role)){
            user.getRoles().remove(role);  // it will remove the role from the user
            userRepository.save(user);
            return "Role removed successfully....";
        }else{
            return "Role not assigned to the user";
        }
    }

}
