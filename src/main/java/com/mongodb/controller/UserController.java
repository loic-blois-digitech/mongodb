package com.mongodb.controller;

import com.mongodb.model.User;
import com.mongodb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createUser(@RequestBody User user) {
        logger.debug("Create a user.");
        this.userService.createUser(user);
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public Collection<User> getAll() {
        this.logger.debug("Getting all users.");
        return this.userService.getAllUsers();
    }

    @GetMapping("/find/{id}")
    public Optional<User> getById(@PathVariable int id) {
        this.logger.debug("Getting one user-id = {}.", id);
        return this.userService.getFindUserById(id);
    }
}
