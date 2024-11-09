package com.sprk.many_to_many.mapper;

import com.sprk.many_to_many.dto.RoleDto;
import com.sprk.many_to_many.entity.Role;

import lombok.Data;

@Data
public class RoleMapper {

    // Conversion of roleDto to role object
    public static Role mappedRoleDtoToRole(RoleDto roleDto, Role role){

        role.setRoleId(roleDto.getRoleId());
        role.setRoleName(roleDto.getRoleName());
        
        return role;
    }

    // Conversion of role to roleDto object
    public static RoleDto mappedRoleToRoleDto(Role role, RoleDto roleDto){

        roleDto.setRoleId(role.getRoleId());
        roleDto.setRoleName(role.getRoleName());

        return roleDto;
    }
}
