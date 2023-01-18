package com.debugging.debugging.controller;

import com.debugging.debugging.model.User;
import com.debugging.debugging.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public List<User> userAll() {
        return userService.findAll();
    }

}
