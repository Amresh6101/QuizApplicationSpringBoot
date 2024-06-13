package com.quiz.management.application.service;

import com.quiz.management.application.dto.QuestionDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.exception.QuestionException;

public interface QuestionService {
    QuestionResponseDTO createQuestion(QuestionDTO questionDTO);
    QuestionResponseDTO getQuestion(Integer id) throws QuestionException;
    void deleteQuestion(Integer id) throws QuestionException;
    QuestionResponseDTO updateQuestion(QuestionDTO questionDTO);
}
