package com.quiz.management.application.service;

import com.quiz.management.application.TestObjects.PreparedTestObjects;
import com.quiz.management.application.dto.QuestionRequestDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.dto.QuizRequestDTO;
import com.quiz.management.application.entity.QuestionEntity;
import com.quiz.management.application.entity.QuizEntity;
import com.quiz.management.application.repository.QuestionRepositry;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class QuestionServiceImplTest {

    @Mock
    QuestionRepositry questionRepositry;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    QuestionService questionService;

//    public QuestionResponseDTO createQuestion(QuestionRequestDTO questionRequestDTO) {
//        QuestionEntity questionEntity = modelMapper.map(questionRequestDTO, QuestionEntity.class);
//        QuizRequestDTO quizRequestDTO = questionRequestDTO.getQuizRequestDTO();
//        QuizEntity quizEntity = modelMapper.map(quizRequestDTO, QuizEntity.class);
//        questionEntity.setQuiz(quizEntity);
//        questionRepository.save(questionEntity);
//        return modelMapper.map(questionRequestDTO, QuestionResponseDTO.class);
//    }
    @Test
    public  void testCreateQuestion(){
       QuestionRequestDTO questionRequestDTO= PreparedTestObjects.getQuestionRequestDTO();
       QuizRequestDTO quizRequestDTO=PreparedTestObjects.getQuizRequestDTO();
       questionRequestDTO.setQuizRequestDTO(quizRequestDTO);
       QuestionEntity questionEntity=PreparedTestObjects.getQuestionEntity();
       QuizEntity quizEntity=PreparedTestObjects.getQuizEntity();
       QuestionResponseDTO questionResponseDTO=PreparedTestObjects.getQuestionResponseDto();
        Mockito.when(modelMapper.map(questionRequestDTO,QuestionEntity.class)).thenReturn(questionEntity);
        Mockito.when(modelMapper.map(quizRequestDTO,QuizEntity.class)).thenReturn(quizEntity);
//        Mockito.when(questionEntity.setQuiz(any(QuizEntity.class))).thenReturn(quizEntity);
//        Mockito.when(questionRepositry.save(any(QuestionEntity.class))).thenReturn(questionEntity);
    }
}
