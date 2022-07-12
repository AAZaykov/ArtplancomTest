package com.aazaykov.artplancomtest.Controllers;

import com.aazaykov.artplancomtest.Entities.User;
import com.aazaykov.artplancomtest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createNewUser(@RequestBody User user, HttpServletRequest request){
        userService.createNewUser(user, request);
        return user;
    }
}