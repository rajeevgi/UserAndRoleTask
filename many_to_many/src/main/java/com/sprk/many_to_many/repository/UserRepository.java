package com.sprk.many_to_many.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sprk.many_to_many.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // custom query to fetch a USers and their associated roles
    @Query("FROM User u JOIN FETCH u.roles WHERE u.userId = :userId")
    Optional<User> findUserWithUserId(int userId);

    @Query("FROM User u JOIN u.roles r WHERE r.id = :roleId")
    List<User> findByRoleId(@Param("roleId") int roleId);

    Optional<User> findByEmail(String email);

}
