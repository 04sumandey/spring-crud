package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.response;

import lombok.Data;

@Data
public class UserResponse<T> {
    Boolean isSuccess;
    T data;

    public UserResponse(T data, Boolean isSuccess) {
        this.data = data;
        this.isSuccess = isSuccess;
    }

    public UserResponse(ErrorResponse error, Boolean isSuccess) {
        this.error = error;
        this.isSuccess = isSuccess;
    }

    ErrorResponse error;
}
