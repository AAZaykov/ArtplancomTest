package com.aazaykov.userpets.Controllers;

import com.aazaykov.userpets.Entities.Role;
import com.aazaykov.userpets.Entities.Status;
import com.aazaykov.userpets.Entities.User;
import com.aazaykov.userpets.Entities.UserDto;
import com.aazaykov.userpets.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createNewUser(@RequestBody UserDto userDto, HttpServletRequest request){
        User user = new User(userDto.getUsername(), userDto.getPassword(), Role.USER, Status.ACTIVE);
        userService.createNewUser(user, request);
        return user;
    }
}