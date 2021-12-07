package com.eazybytes.employeeservice.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class EmployeeGlobalExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        EmployeeExceptionResponse exception = new EmployeeExceptionResponse(ex.getMessage(),
                request.getDescription(false),
                new Date());
        return new ResponseEntity<>(exception, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(Exception ex, WebRequest request){
        EmployeeExceptionResponse exception = new EmployeeExceptionResponse(ex.getMessage(),
                request.getDescription(false),
                new Date());
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
