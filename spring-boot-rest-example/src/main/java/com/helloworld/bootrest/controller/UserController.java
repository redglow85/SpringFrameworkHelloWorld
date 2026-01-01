package com.helloworld.bootrest.controller;

import com.helloworld.bootrest.dto.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public UserResponse getUser(@PathVariable long id) {
        return new UserResponse(id, "User-" + id);
    }
}


