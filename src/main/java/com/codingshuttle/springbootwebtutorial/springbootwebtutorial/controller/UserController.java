package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controller;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.UserDto;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.response.UserResponse;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserResponse<UserDto>> getUser(@PathVariable(value = "userId",required = true) long id) throws Exception{
        UserResponse<UserDto> userResponse= userService.getUserById(id);
        if(userResponse.getIsSuccess()){
            return new ResponseEntity<UserResponse<UserDto>>(userResponse, HttpStatus.OK);
        }else if(userResponse.getError().getCode()=="USER_NOT_FOUND"){
            return new ResponseEntity<UserResponse<UserDto>>(userResponse, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<UserResponse<UserDto>>(userResponse, HttpStatus.BAD_REQUEST);
        }

    }
}
