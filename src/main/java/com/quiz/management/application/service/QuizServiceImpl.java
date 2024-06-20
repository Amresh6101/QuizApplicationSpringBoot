package com.quiz.management.application.service;

import com.quiz.management.application.dto.QuestionRequestDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.dto.QuizRequestDTO;
import com.quiz.management.application.dto.QuizResponseDTO;
import com.quiz.management.application.entity.QuestionEntity;
import com.quiz.management.application.entity.QuizEntity;
import com.quiz.management.application.exception.QuizException;
import com.quiz.management.application.repository.QuizRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuizResponseDTO createQuiz(QuizRequestDTO quizRequestDTO) {
        QuizEntity quiz = this.quizRepository.findByCategory(quizRequestDTO.getCategory())
                .orElse(modelMapper.map(quizRequestDTO, QuizEntity.class));
        List<QuestionEntity> QuestionRequestDTOList = quiz.getQuestions();
        QuestionRequestDTOList.stream().forEach(question -> question.setQuiz(quiz));
        quizRepository.save(quiz);
        QuizRequestDTO resQuizRequestDTO = modelMapper.map(quiz, QuizRequestDTO.class);
        return modelMapper.map(resQuizRequestDTO, QuizResponseDTO.class);
    }

    @Override
    public List<QuestionResponseDTO> getQuiz(Integer id) throws QuizException {
        Optional<QuizEntity> quizOptional = quizRepository.findById(id);
        List<QuestionRequestDTO> listOfQuestonDTO = quizOptional.map(quizEntity -> quizEntity.getQuestions().stream()
                .map((questionEntity) -> modelMapper.map(questionEntity, QuestionRequestDTO.class))
                .collect(Collectors.toList())
        ).orElseThrow(() -> new QuizException("Quiz Not Found!!"));
        return listOfQuestonDTO.stream()
                .map(questionRequestDTO -> modelMapper.map(questionRequestDTO, QuestionResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteQuiz(Integer quizid) throws QuizException {
        quizRepository.findById(quizid).orElseThrow(() -> new QuizException("No Quiz found for this id"));
        quizRepository.deleteById(quizid);
    }

    @Override
    public QuizResponseDTO updateQuiz(QuizRequestDTO quizRequestDTO) {
        System.out.println(quizRequestDTO.toString());
        QuizEntity quizEntity = modelMapper.map(quizRequestDTO, QuizEntity.class);
        System.out.println(quizEntity.toString());
        quizEntity.getQuestions().forEach((question) -> question.setQuiz(quizEntity));
        quizRepository.save(quizEntity);
        return modelMapper.map(quizRequestDTO, QuizResponseDTO.class);
    }
}
