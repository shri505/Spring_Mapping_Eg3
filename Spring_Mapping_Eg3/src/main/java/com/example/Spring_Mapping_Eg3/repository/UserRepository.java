package com.example.Spring_Mapping_Eg3.repository;

import com.example.Spring_Mapping_Eg3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}