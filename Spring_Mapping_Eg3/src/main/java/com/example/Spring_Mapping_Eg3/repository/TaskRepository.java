package com.example.Spring_Mapping_Eg3.repository;



import com.example.Spring_Mapping_Eg3.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
