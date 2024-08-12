package com.example.Spring_Mapping_Eg3.repository;

import com.example.Spring_Mapping_Eg3.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}