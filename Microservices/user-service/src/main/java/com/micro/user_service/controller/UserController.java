package com.micro.user_service.controller;

import com.micro.user_service.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    // This will capture the running port of this instance
    @Value("${server.port}")
    private String port;

    @GetMapping
    public List<String> getUsers() {

        return Arrays.asList(
                "Response from USER-SERVICE instance running on port : " + port,
                "User 1 : Pritish",
                "User 2 : Rahul"
        );
    }

    // API to get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {

        if(id != 1){
            throw new RuntimeException("User not found with id " + id);
        }

        return new User(1,"Pritish");
    }

    // Exception handler inside same controller
    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException ex){
        return ex.getMessage();
    }
}