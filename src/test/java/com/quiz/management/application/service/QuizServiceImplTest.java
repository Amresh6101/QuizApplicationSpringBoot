package com.quiz.management.application.service;


import com.quiz.management.application.TestObjects.PreparedTestObjects;
import com.quiz.management.application.dto.QuestionRequestDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.dto.QuizRequestDTO;
import com.quiz.management.application.dto.QuizResponseDTO;
import com.quiz.management.application.entity.QuestionEntity;
import com.quiz.management.application.entity.QuizEntity;
import com.quiz.management.application.exception.QuizException;
import com.quiz.management.application.repository.QuizRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class QuizServiceImplTest {

    @Mock
    QuizRepository quizRepository;
    @Mock
    ModelMapper modelMapper;
    @InjectMocks
    QuizServiceImpl quizService;

    @Test
    public void testCreateQuiz() {
        QuizRequestDTO quizRequestDTO = PreparedTestObjects.getQuizRequestDTO();
        QuestionRequestDTO questionRequestDTO = PreparedTestObjects.getQuestionRequestDTO();
        quizRequestDTO.setQuestions(List.of(questionRequestDTO));
        questionRequestDTO.setQuizRequestDTO(quizRequestDTO);
        QuizEntity quizEntity = PreparedTestObjects.getQuizEntity();
        QuestionEntity questionEntity = PreparedTestObjects.getQuestionEntity();
        quizEntity.setQuestions(List.of(questionEntity));
        questionEntity.setQuiz(quizEntity);
        QuizResponseDTO quizResponseDTO1 = PreparedTestObjects.getQuizResponseDto();
        QuestionResponseDTO questionResponseDTO = PreparedTestObjects.getQuestionResponseDto();
        quizResponseDTO1.setQuestions(List.of(questionResponseDTO));

        when(quizRepository.findByCategory(Mockito.anyString())).thenReturn(Optional.of(quizEntity));
        when(quizRepository.save(any())).thenReturn(any());

        QuizResponseDTO quizResponseDTO = quizService.createQuiz(quizRequestDTO);
        assertNull(quizResponseDTO);
        verify(quizRepository, Mockito.atLeastOnce()).findByCategory(Mockito.anyString());
        verify(quizRepository, Mockito.times(1)).save(any());
    }

    @Test
    public void testGetQuiz_QuizFound() throws QuizException {
        QuestionEntity questionEntity = PreparedTestObjects.getQuestionEntity();
        QuizEntity quizEntity = PreparedTestObjects.getQuizEntity();
        quizEntity.setQuestions(List.of(questionEntity));
        questionEntity.setQuiz(quizEntity);
        when(quizRepository.findById(1)).thenReturn(Optional.of(quizEntity));
        List<QuestionResponseDTO> result = quizService.getQuiz(1);
        assertThat(result.size()).isEqualTo(1);
        verify(quizRepository, Mockito.atLeastOnce()).findById(Mockito.anyInt());
    }

    @Test
    public void testGetQuiz_NotFound() {
        when(quizRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(QuizException.class, () -> quizService.getQuiz(1), "Quiz Not Found for this Id");
    }

    @Test
    public void testDeleteQuiz() {
        quizRepository.deleteById(1);
        verify(quizRepository, Mockito.times(1)).deleteById(1);
    }

//    public QuizResponseDTO updateQuiz(QuizRequestDTO quizRequestDTO) {
//        QuizEntity quizEntity=modelMapper.map(quizRequestDTO,QuizEntity.class);
//        quizEntity.getQuestions().forEach((question)->question.setQuiz(quizEntity));
//        quizRepository.save(quizEntity);
//        return modelMapper.map(quizRequestDTO,QuizResponseDTO.class);
//    }

//    @Test
//    public void testUpdateQuiz() {
//
//        QuizEntity quizEntity1=PreparedTestObjects.getQuizEntity();
//        QuestionEntity questionEntity=PreparedTestObjects.getQuestionEntity();
//        quizEntity1.setQuestions(List.of(questionEntity));
//        questionEntity.setQuiz(quizEntity1);
//
//        QuizRequestDTO quizRequestDTO=PreparedTestObjects.getQuizRequestDTO();
//        QuestionRequestDTO questionRequestDTO=PreparedTestObjects.getQuestionRequestDTO();
//        questionRequestDTO.setQuizRequestDTO(quizRequestDTO);
//        quizRequestDTO.setQuestions(List.of(questionRequestDTO));
//
//        QuizResponseDTO quizResponseDTO=PreparedTestObjects.getQuizResponseDto();
//
//        //when(quizEntity.getQuestions()).thenReturn(List.of(PreparedTestObjects.getQuestionEntity()));
//        when(quizRepository.save(any())).thenReturn(quizEntity1);
//
//        QuizResponseDTO result= quizService.updateQuiz(quizRequestDTO);
//
//        assertThat(result).isEqualTo(quizResponseDTO);
//        Mockito.verify(quizRepository).save(any());
//    }
}
