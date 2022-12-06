package ru.k2.swaggerdemotinkoff.support;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> handleException(ConstraintViolationException ex){
     return  new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
}
