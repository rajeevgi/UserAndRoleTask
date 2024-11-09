package com.sprk.many_to_many.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprk.many_to_many.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}
