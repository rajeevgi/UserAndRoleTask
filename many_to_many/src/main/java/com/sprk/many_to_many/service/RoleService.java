package com.sprk.many_to_many.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprk.many_to_many.dto.RoleDto;
import com.sprk.many_to_many.entity.Role;
import com.sprk.many_to_many.mapper.RoleMapper;
import com.sprk.many_to_many.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Post mapping to add role
    public RoleDto saveRole(RoleDto roleDto) {
        
        Role role = RoleMapper.mappedRoleDtoToRole(roleDto, new Role());

        roleRepository.save(role);
        roleDto.setRoleId(role.getRoleId());

        return roleDto;
    }

    // Get mapping to get role by id
    public RoleDto getRoleById(int roleId) {
       Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found with Id: "+roleId));
    
       RoleDto roleDto = RoleMapper.mappedRoleToRoleDto(role, new RoleDto());
       return roleDto;
    }

    // Get mapping to get all the roles
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        List<RoleDto> roleDtos = new ArrayList<>();

        for(Role role : roles){
            RoleDto roleDto = RoleMapper.mappedRoleToRoleDto(role, new RoleDto());
            roleDtos.add(roleDto);
        }
        return roleDtos;
    }

    // Delete mapping to delete role
    public String deleteRoleById(int roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found with id:"+roleId));

        roleRepository.delete(role);

        return "Role deleted successfully...";
    }

}
