package com.sprk.many_to_many.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprk.many_to_many.dto.UserDto;
import com.sprk.many_to_many.entity.User;
import com.sprk.many_to_many.mapper.UserMapper;
import com.sprk.many_to_many.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save/Post mapping
    public UserDto saveUser(UserDto userDto) {
        
        User user = UserMapper.mappedUserDtoToUser(userDto, new User());
        userRepository.save(user);
        userDto.setUserId(user.getUserId());

        return userDto;
        
    }

    // Get mapping to get user by id
    public UserDto getUserById(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: "+userId));
        return UserMapper.mappedUserToUserDto(user, new UserDto());
    }


    // Get mapping to get All users
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();

        for(User user : users){
            UserDto userDto = UserMapper.mappedUserToUserDto(user, new UserDto());
            userDtos.add(userDto);
        }

        return userDtos;
    }

    // Get mapping to get user by email
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found with Email."));

        return UserMapper.mappedUserToUserDto(user, new UserDto());
    }

    // Delete mapping to delete particular user
    public String deleteUser(int userId) {
        
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found."));

        userRepository.delete(user);

        return "User with user Id: "+userId+" deleted successfully.";
        
    }

    // Put mapping to update user data
    public String updateUserById(int userId, UserDto userDto) {
            
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with Id:"+userId));
    
        if(user.getUserName() != null){
            user.setUserName(userDto.getUserName());
        }

        if(user.getEmail() != null){
            user.setEmail(userDto.getEmail());
        }

        if(user.getPassword() != null){
            user.setPassword(userDto.getPassword());
        }

        userRepository.save(user);
        return "User with userId: "+userId+" updated Successfully...";   
    }

}
