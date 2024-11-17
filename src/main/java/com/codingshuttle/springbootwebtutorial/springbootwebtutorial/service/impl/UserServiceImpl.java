package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.service.impl;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.UserDto;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.response.ErrorResponse;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.response.UserResponse;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entity.UserEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.respository.UserRepository;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.service.UserService;
import org.apache.coyote.BadRequestException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public UserResponse<UserDto> getUserById(long id) throws Exception{
        try{
            if(id<1){
                throw new BadRequestException("bad request");
            }

            Optional<UserEntity> userEntityOpt= userRepository.findById(id);
            if (userEntityOpt.isEmpty()){
                throw new ResourceNotFoundException("User does not exists");
            }

            UserEntity userEntity=userEntityOpt.get();
            UserDto userDto=new UserDto(userEntity.getFirstName(),userEntity.getLastName());
            return new UserResponse<UserDto>(userDto,true);

        }catch (ResourceNotFoundException re){
            ErrorResponse errorResponse=new ErrorResponse("USER_NOT_FOUND","user does not exists");
            return new UserResponse<UserDto>(errorResponse,false);
        } catch (Exception e){
            ErrorResponse errorResponse=new ErrorResponse("BAD_REQUEST","Bad Request");
            return new UserResponse<UserDto>(errorResponse,false);
        }
    }
}
