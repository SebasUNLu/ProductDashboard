package com.example.productDashboard;

import com.example.productDashboard.ErrorDetails.GenericErrorDetails;
import com.example.productDashboard.ErrorDetails.NotValidationErrorDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<NotValidationErrorDetails> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> {
                    System.out.println("Field: " + error.getField() + ", message: " + error.getDefaultMessage());
                    errorMap.put(error.getField(), error.getDefaultMessage());
                }
        );
        NotValidationErrorDetails errorDetails = new NotValidationErrorDetails(HttpStatus.BAD_REQUEST, errorMap);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

/*
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Object> handleObjectNotFoundException(ObjectNotFoundException ex, WebRequest request) {
        System.out.println("1");
        LOG.error(ex.getMessage(), ex.getCause());
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDetails> handleConstraintViolationExceptions(ConstraintViolationException ex, WebRequest request) {
        System.out.println("2");
        System.out.println("Errors");
        System.out.println(ex.getMessage());
        System.out.println(ex.getCause());
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    */


    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {

        LOG.error(ex.getMessage());
        System.out.println(ex.getCause());

        GenericErrorDetails errorDetails = new GenericErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
