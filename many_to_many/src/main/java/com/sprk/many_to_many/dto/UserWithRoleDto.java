package com.sprk.many_to_many.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserWithRoleDto {

    private int userId;

    private String userName;

    private String email;

    private String password;

    private List<RoleDto> roles;
}
