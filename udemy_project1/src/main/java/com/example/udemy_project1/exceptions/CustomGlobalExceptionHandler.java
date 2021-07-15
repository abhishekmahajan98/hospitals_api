package com.example.udemy_project1.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Set;


//globally applicable to all controllers using controller advice
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomErrorDetails customErrorDetails= new CustomErrorDetails(
                new Date(),
                "From method arguement not valid in GEH","" +
        ex.getMessage());
        return new ResponseEntity<Object>(customErrorDetails,HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomErrorDetails customErrorDetails= new CustomErrorDetails(
                new Date(),
                "From HttpRequestMethodNotSupported in GEH-method not allowed","" +
                ex.getMessage());
        return new ResponseEntity<Object>(customErrorDetails,HttpStatus.METHOD_NOT_ALLOWED);
    }

    //custom usernamenotfound exception
    @ExceptionHandler(value= UsernameNotFoundException.class)
    public final ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException ex,WebRequest request){
        CustomErrorDetails customErrorDetails= new CustomErrorDetails(
                new Date(),
                ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<Object>(customErrorDetails,HttpStatus.NOT_FOUND);
    }

    //custom constraint violation exception
    @ExceptionHandler(value = ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,WebRequest request){
        CustomErrorDetails customErrorDetails= new CustomErrorDetails(
                new Date(),
                ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<Object>(customErrorDetails,HttpStatus.BAD_REQUEST);
    }
}
