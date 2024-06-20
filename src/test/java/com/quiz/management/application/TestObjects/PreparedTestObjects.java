package com.quiz.management.application.TestObjects;

import com.quiz.management.application.dto.QuestionRequestDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.dto.QuizRequestDTO;
import com.quiz.management.application.dto.QuizResponseDTO;
import com.quiz.management.application.entity.QuestionEntity;
import com.quiz.management.application.entity.QuizEntity;

import java.util.Arrays;

public class PreparedTestObjects {

    public static QuizEntity getQuizEntity() {
        QuizEntity quizEntity = new QuizEntity();
        quizEntity.setId(1);
        quizEntity.setCategory("DotNet");
        // quizEntity.setQuestions(Arrays.asList(getQuestionEntity()));
        return quizEntity;
    }

    public static QuizRequestDTO getQuizRequestDTO() {
        QuizRequestDTO quizRequestDTO = new QuizRequestDTO();
        quizRequestDTO.setId(1);
        quizRequestDTO.setCategory("DotNet");
        //  quizRequestDTO.setQuestions(Arrays.asList(getQuestionRequestDTO()));
        return quizRequestDTO;
    }

    public static QuizResponseDTO getQuizResponseDto() {
        QuizResponseDTO quizResponseDTO = new QuizResponseDTO();
        quizResponseDTO.setId(1);
        quizResponseDTO.setCategory("DotNet");
        quizResponseDTO.setQuestions(Arrays.asList(getQuestionResponseDto()));
        return quizResponseDTO;
    }

    public static QuestionEntity getQuestionEntity() {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId(1);
        questionEntity.setCategory("DotNet");
        questionEntity.setDescription("What is DotNet and ASP Dot net");
        questionEntity.setOptions(Arrays.asList("one1", "two2", "three3"));
        questionEntity.setCorrectOption(1);
        questionEntity.setDifficulty("Easy");
        //  questionEntity.setQuiz(getQuizEntity());
        return questionEntity;
    }

    public static QuestionRequestDTO getQuestionRequestDTO() {
        QuestionRequestDTO questionRequestDTO = new QuestionRequestDTO();
        questionRequestDTO.setId(1);
        questionRequestDTO.setCategory("DotNet");
        questionRequestDTO.setDescription("What is DotNet and ASP Dot net");
        questionRequestDTO.setCorrectOption(1);
        questionRequestDTO.setOptions(Arrays.asList("one1", "two2", "three3"));
        questionRequestDTO.setDifficulty("Easy");
        //  questionRequestDTO.setQuizRequestDTO(getQuizRequestDTO());
        return questionRequestDTO;
    }

    public static QuestionResponseDTO getQuestionResponseDto() {
        QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
        questionResponseDTO.setId(1);
        questionResponseDTO.setCategory("DotNet");
        questionResponseDTO.setOptions(Arrays.asList("one1", "two2", "three3"));
        questionResponseDTO.setDifficulty("Easy");
        questionResponseDTO.setCorrectOption(1);
        questionResponseDTO.setDescription("What is DotNet and ASP Dot net");
        return questionResponseDTO;
    }
}
