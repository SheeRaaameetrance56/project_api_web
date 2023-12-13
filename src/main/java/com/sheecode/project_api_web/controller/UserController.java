package com.sheecode.project_api_web.controller;

import com.sheecode.project_api_web.exceptions.userNotFoundException;
import com.sheecode.project_api_web.model.User;
import com.sheecode.project_api_web.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserRepo userRepository;

    @PostMapping("/save_user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("user/{id}")
    User getUserById(@PathVariable int id){
        return userRepository.findById(id)
                .orElseThrow(()->new userNotFoundException(id));
    }

    @PutMapping("/update_user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable int id){
        return userRepository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            user.setAddress(newUser.getAddress());
            return userRepository.save(user);
        }).orElseThrow(()->new userNotFoundException(id));
    }

}
