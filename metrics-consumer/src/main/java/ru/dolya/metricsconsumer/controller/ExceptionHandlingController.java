package ru.dolya.metricsconsumer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.dolya.metricsconsumer.exception.MetricNotFoundException;

@RestControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(MetricNotFoundException.class)
    public ResponseEntity<String> handleEntityNotExistsException(MetricNotFoundException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}