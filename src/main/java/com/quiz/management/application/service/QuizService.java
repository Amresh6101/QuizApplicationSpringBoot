package com.quiz.management.application.service;

import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.dto.QuizRequestDTO;
import com.quiz.management.application.dto.QuizResponseDTO;
import com.quiz.management.application.exception.QuizException;

import java.util.List;

public interface QuizService {
    QuizResponseDTO createQuiz(QuizRequestDTO quizRequestDTO);

    List<QuestionResponseDTO> getQuiz(Integer id) throws QuizException;

    void deleteQuiz(Integer id) throws QuizException;

    QuizResponseDTO updateQuiz(QuizRequestDTO quizRequestDTO);
}
