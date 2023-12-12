package com.sheecode.project_api_web.controller;

import com.sheecode.project_api_web.model.User;
import com.sheecode.project_api_web.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepository;

    @PostMapping("/save_user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

}
