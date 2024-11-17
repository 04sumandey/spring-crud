package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.service;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.UserDto;

public interface UserService {
    UserDto getUserById(String id);
}
