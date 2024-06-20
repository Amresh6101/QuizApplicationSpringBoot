package com.quiz.management.application.service;

import com.quiz.management.application.dto.QuestionRequestDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.exception.QuestionException;
import com.quiz.management.application.exception.QuizException;

public interface QuestionService {
    QuestionResponseDTO createQuestion(QuestionRequestDTO questionRequestDTO);

    QuestionResponseDTO getQuestion(Integer id) throws QuestionException;

    void deleteQuestion(Integer id) throws QuestionException, QuizException;

    QuestionResponseDTO updateQuestion(QuestionRequestDTO questionRequestDTO);
}
