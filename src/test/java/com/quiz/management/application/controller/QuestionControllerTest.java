package com.quiz.management.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.management.application.TestObjects.PreparedTestObjects;
import com.quiz.management.application.dto.QuestionRequestDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.service.QuestionService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;


@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    QuestionService questionService;

    @Test
    public void testCreateQuestion() throws Exception {
        QuestionResponseDTO questionResponseDTO = PreparedTestObjects.getQuestionResponseDto();
        QuestionRequestDTO questionRequestDTO = PreparedTestObjects.getQuestionRequestDTO();
        Mockito.when(questionService.createQuestion(Mockito.any(QuestionRequestDTO.class))).thenReturn(questionResponseDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/questions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(questionRequestDTO))).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testGetQuestion() throws Exception {
        int questionid = PreparedTestObjects.getQuestionEntity().getId();
        QuestionResponseDTO dummyList = PreparedTestObjects.getQuestionResponseDto();
        Mockito.when(questionService.getQuestion(anyInt())).thenReturn(dummyList);
        mockMvc.perform(MockMvcRequestBuilders.get("/questions/" + questionid)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteQuestion() throws Exception {
        int questionId=PreparedTestObjects.getQuestionEntity().getId();
        Mockito.doNothing().when(questionService).deleteQuestion(anyInt());
        mockMvc.perform(MockMvcRequestBuilders.delete("/questions/"+questionId)).andExpect(MockMvcResultMatchers.status().isGone());
    }

    @Test
    public void testUpdateQuestion() throws Exception {
        QuestionResponseDTO questionResponseDTO=PreparedTestObjects.getQuestionResponseDto();
        QuestionRequestDTO questionRequestDTO=PreparedTestObjects.getQuestionRequestDTO();
        Mockito.when(questionService.updateQuestion(any(QuestionRequestDTO.class))).thenReturn(questionResponseDTO);
        mockMvc.perform(MockMvcRequestBuilders
                .put("/questions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(questionRequestDTO))
        ).andExpect(MockMvcResultMatchers.status().isAccepted());

    }

}
