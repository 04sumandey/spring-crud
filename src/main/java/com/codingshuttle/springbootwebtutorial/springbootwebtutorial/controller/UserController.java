package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controller;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.UserDto;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable(value = "userId",required = true) String id){
        return userService.getUserById(id);
    }
}
