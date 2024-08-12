package com.example.Spring_Mapping_Eg3.service;

import com.example.Spring_Mapping_Eg3.entity.Profile;
import com.example.Spring_Mapping_Eg3.entity.User;
import com.example.Spring_Mapping_Eg3.repository.ProfileRepository;
import com.example.Spring_Mapping_Eg3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(User user) {
        if (user.getProfile() != null) {
            Profile profile = user.getProfile();
            profile = profileRepository.save(profile);
            user.setProfile(profile);
        }
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        if (user.getProfile() != null) {
            Profile profile = user.getProfile();
            profile = profileRepository.save(profile);
            user.setProfile(profile);
        }
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
