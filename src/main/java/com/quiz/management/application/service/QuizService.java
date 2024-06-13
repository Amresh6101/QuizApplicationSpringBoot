package com.quiz.management.application.service;

import com.quiz.management.application.dto.QuestionDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.dto.QuizDTO;
import com.quiz.management.application.dto.QuizResponseDTO;
import com.quiz.management.application.entity.QuizEntity;
import com.quiz.management.application.exception.QuestionException;
import com.quiz.management.application.exception.QuizException;

import java.util.List;

public interface QuizService {
    QuizResponseDTO createQuiz(QuizDTO quizDTO);
    List<QuestionResponseDTO> getQuiz(Integer id) throws  QuizException;
    void deleteQuiz(Integer id) throws QuizException;
    QuizResponseDTO updateQuiz(QuizDTO quizDTO);
}
