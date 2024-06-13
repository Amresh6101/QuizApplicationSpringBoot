package com.quiz.management.application.handler;


import com.quiz.management.application.exception.QuestionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuestionExceptionHandler {
    @ExceptionHandler(QuestionException.class)
    public String questionExceptionHandler(QuestionException ex){
        return ex.getMessage();
    }
}
