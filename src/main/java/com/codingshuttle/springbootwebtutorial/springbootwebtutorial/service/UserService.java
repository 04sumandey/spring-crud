package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.service;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.UserDto;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.response.UserResponse;

public interface UserService {
    UserResponse<UserDto> getUserById(long id) throws Exception;
}
