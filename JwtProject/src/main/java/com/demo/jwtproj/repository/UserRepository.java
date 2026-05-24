package com.demo.jwtproj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.jwtproj.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser,Integer> {

    Optional<AppUser> findByUsername(String username);
}
