package com.example.springboot.error.springbooterror.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.springboot.error.springbooterror.models.ErrorDto;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorDto> divisionByZero(Exception e){

        ErrorDto error = new ErrorDto();
        error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(e.getMessage());
        error.setDate(new Date());
        return ResponseEntity.internalServerError().body(error);
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDto> notFound(NoHandlerFoundException e){
        ErrorDto error = new ErrorDto();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setDate(new Date());

        // Esta es otra forma de regresare el error personalizado
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    // Otra forma de hacer lo anterior
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatExc(NumberFormatException e){
        Map<String, Object> error = new HashMap<>();
        error.put("estatus", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("message", e.getMessage());
        error.put("date", new Date());

        return error;
    }
    
}
