package com.example.Spring_Mapping_Eg3.repository;

import com.example.Spring_Mapping_Eg3.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
