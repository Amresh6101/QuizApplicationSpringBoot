package com.quiz.management.application.handler;

import com.quiz.management.application.exception.QuizException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuizExceptionHandler {
    @ExceptionHandler(QuizException.class)
    public String quizExceptionHandler(QuizException ex){
        return  ex.getMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    public String quizRuntimeExceptionHandler(RuntimeException ex) {
        return ex.getMessage();
    }
}
