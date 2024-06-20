package com.quiz.management.application.controller;

import com.quiz.management.application.dto.QuestionRequestDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.exception.QuestionException;
import com.quiz.management.application.exception.QuizException;
import com.quiz.management.application.service.QuestionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "questions")
@Slf4j
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponseDTO> createQuestion(@Valid @RequestBody QuestionRequestDTO QuestionRequestDTO) {
        log.info("Adding Question to the quiz with category: {}", QuestionRequestDTO.getCategory());
        return new ResponseEntity<QuestionResponseDTO>(questionService.createQuestion(QuestionRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public QuestionResponseDTO getQuestion(@PathVariable Integer id) throws QuestionException {
        return questionService.getQuestion(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Integer id) throws QuestionException, QuizException {
        questionService.deleteQuestion(id);
        return new ResponseEntity<Void>(HttpStatus.GONE);
    }

    @PutMapping
    public ResponseEntity<QuestionResponseDTO> updateQuestion(@Valid @RequestBody QuestionRequestDTO QuestionRequestDTO) {
        QuestionResponseDTO questionResponseDTO = questionService.updateQuestion(QuestionRequestDTO);
        return new ResponseEntity<QuestionResponseDTO>(questionResponseDTO, HttpStatus.ACCEPTED);
    }
}
