package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controller;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable(value = "userId",required = true) String id){
        return new UserDto("Mrityunjoy", "Dey");
    }
}