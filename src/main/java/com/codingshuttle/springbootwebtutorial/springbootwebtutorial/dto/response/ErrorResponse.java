package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    String code;
    String message;
}
