package com.quiz.management.application.controller;

import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.dto.QuizRequestDTO;
import com.quiz.management.application.dto.QuizResponseDTO;
import com.quiz.management.application.exception.QuizException;
import com.quiz.management.application.service.QuizService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quizzes")
@Slf4j
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public ResponseEntity<QuizResponseDTO> createQuiz(@Valid @RequestBody QuizRequestDTO quizRequestDTO) {
        log.info("Creating quiz with category: {}", quizRequestDTO.getCategory());
        QuizResponseDTO quizResponseDTO = quizService.createQuiz(quizRequestDTO);
        return new ResponseEntity<QuizResponseDTO>(quizResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public List<QuestionResponseDTO> getQuiz(@PathVariable Integer id) throws QuizException {
        return quizService.getQuiz(id);
    }

    @DeleteMapping("/{quizid}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Integer quizid) throws QuizException {
        quizService.deleteQuiz(quizid);
        return new ResponseEntity<Void>(HttpStatus.GONE);
    }

    @PutMapping
    public ResponseEntity<QuizResponseDTO> updateQuiz(@RequestBody QuizRequestDTO QuizRequestDTO) {
        QuizResponseDTO quizResponseDTO = quizService.updateQuiz(QuizRequestDTO);
        return new ResponseEntity<QuizResponseDTO>(quizResponseDTO, HttpStatus.ACCEPTED);
    }

}
