package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.service.impl;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.UserDto;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public UserDto getUserById(String id){
        return new UserDto("Mrityunjoy", "Dey");
    }
}
