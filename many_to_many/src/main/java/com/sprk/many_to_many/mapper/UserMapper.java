package com.sprk.many_to_many.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sprk.many_to_many.dto.RoleDto;
import com.sprk.many_to_many.dto.UserDto;
import com.sprk.many_to_many.dto.UserWithRoleDto;
import com.sprk.many_to_many.entity.Role;
import com.sprk.many_to_many.entity.User;

import lombok.Data;

@Data
public class UserMapper {

    // Conversion of userDto to user object
    public static User mappedUserDtoToUser(UserDto userDto, User user){

        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

    // Conversion of user to userDto object
    public static UserDto mappedUserToUserDto(User user, UserDto userDto){

        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    // Conversion of user to UserWithRoleDto object
    public static UserWithRoleDto mappedUserToUserWithRoleDto(User user, UserWithRoleDto userWithRoleDto){

        userWithRoleDto.setUserId(user.getUserId());
        userWithRoleDto.setUserName(user.getUserName());
        userWithRoleDto.setEmail(user.getEmail());
        userWithRoleDto.setPassword(user.getPassword());

        List<Role> roles = user.getRoles();

        List<RoleDto> roleDtos = new ArrayList<>();

        for(Role role : roles){
            RoleDto roleDto = RoleMapper.mappedRoleToRoleDto(role, new RoleDto());
            roleDtos.add(roleDto);
        }

        userWithRoleDto.setRoles(roleDtos);

        return userWithRoleDto;
    }
}
