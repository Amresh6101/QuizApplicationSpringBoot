package com.quiz.management.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.management.application.TestObjects.PreparedTestObjects;
import com.quiz.management.application.dto.QuestionRequestDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.dto.QuizRequestDTO;
import com.quiz.management.application.dto.QuizResponseDTO;
import com.quiz.management.application.service.QuizService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@SpringBootTest
@AutoConfigureMockMvc
public class QuizControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    QuizService quizService;

    @Test
    public void testPostQuiz() throws Exception {

        QuizResponseDTO quizResponseDTO = PreparedTestObjects.getQuizResponseDto();
        QuizRequestDTO quizRequestDTO = PreparedTestObjects.getQuizRequestDTO();
        QuestionRequestDTO questionRequestDTO = PreparedTestObjects.getQuestionRequestDTO();
        QuestionResponseDTO questionResponseDTO = PreparedTestObjects.getQuestionResponseDto();
        quizRequestDTO.setQuestions(List.of(questionRequestDTO));
        Mockito.when(quizService.createQuiz(Mockito.any())).thenReturn(quizResponseDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/quizzes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(quizRequestDTO))).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testGetQuiz() throws Exception {
        int quizid = PreparedTestObjects.getQuizEntity().getId();
        List<QuestionResponseDTO> dummyList = List.of(PreparedTestObjects.getQuestionResponseDto());
        Mockito.when(quizService.getQuiz(anyInt())).thenReturn(dummyList);
        mockMvc.perform(MockMvcRequestBuilders.get("/quizzes/" + quizid)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteQuiz() throws Exception {
        int quizid = PreparedTestObjects.getQuizEntity().getId();
        Mockito.doNothing().when(quizService).deleteQuiz(anyInt());
        mockMvc.perform(MockMvcRequestBuilders.delete("/quizzes/" + quizid)).andExpect(MockMvcResultMatchers.status().isGone());
    }

    @Test
    public void testUpdateQuiz() throws Exception {
        QuizResponseDTO quizResponseDTO = PreparedTestObjects.getQuizResponseDto();
        QuizRequestDTO quizRequestDTO = PreparedTestObjects.getQuizRequestDTO();
        QuestionRequestDTO questionRequestDTO = PreparedTestObjects.getQuestionRequestDTO();
        QuestionResponseDTO questionResponseDTO = PreparedTestObjects.getQuestionResponseDto();
        quizRequestDTO.setQuestions(List.of(questionRequestDTO));
        quizResponseDTO.setQuestions(List.of(questionResponseDTO));
        Mockito.when(quizService.updateQuiz(any())).thenReturn(quizResponseDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/quizzes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(quizRequestDTO))).andExpect(MockMvcResultMatchers.status().isAccepted());
    }
}
