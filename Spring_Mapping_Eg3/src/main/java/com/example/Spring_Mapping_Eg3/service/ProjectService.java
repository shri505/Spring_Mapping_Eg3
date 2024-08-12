package com.example.Spring_Mapping_Eg3.service;

import com.example.Spring_Mapping_Eg3.entity.Project;
import com.example.Spring_Mapping_Eg3.entity.User;
import com.example.Spring_Mapping_Eg3.repository.ProjectRepository;
import com.example.Spring_Mapping_Eg3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private UserRepository userRepo;

    public Project assignProjectToUser(Long userId, Long projectId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));

        project.setUser(user);
        return projectRepo.save(project);
    }

    public Project createProject(Project project) {
        User user = project.getUser();
        user = userRepo.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        project.setUser(user);
        return projectRepo.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepo.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public Project updateProject(Long id, Project project) {
        if (!projectRepo.existsById(id)) {
            throw new RuntimeException("Project not found");
        }
        project.setId(id);
        return projectRepo.save(project);
    }

    public void deleteProject(Long id) {
        if (!projectRepo.existsById(id)) {
            throw new RuntimeException("Project not found");
        }
        projectRepo.deleteById(id);
    }
}
