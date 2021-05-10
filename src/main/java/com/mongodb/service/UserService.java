package com.mongodb.service;

import com.mongodb.model.User;
import com.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return this.userRepository.save(user);
    }
    public Collection<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getFindUserById(int id) {
        return this.userRepository.findById(id);
    }
}
