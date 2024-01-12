package com.myblog.myblog11.exception;

import com.myblog.myblog11.payload.ErrorDtails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDtails> handleResourceNotFoundException(
            ResourceNotFoundException e,
            WebRequest webRequest
    ){
        ErrorDtails errorDtails = new ErrorDtails(e.getMessage(),new Date(),webRequest.getDescription(true));
        return new ResponseEntity<>(errorDtails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
