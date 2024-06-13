package com.quiz.management.application.service;

import com.quiz.management.application.dto.QuestionDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.dto.QuizDTO;
import com.quiz.management.application.dto.QuizResponseDTO;
import com.quiz.management.application.entity.QuestionEntity;
import com.quiz.management.application.entity.QuizEntity;
import com.quiz.management.application.exception.QuizException;
import com.quiz.management.application.repository.QuizRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuizResponseDTO createQuiz( QuizDTO quizDTO) {
        QuizEntity quizEntity=modelMapper.map(quizDTO,QuizEntity.class);
        List<QuestionEntity> questionDTOList= quizEntity.getQuestions();
        for(QuestionEntity question: questionDTOList){
            question.setQuiz(quizEntity);
        }
        quizRepository.save(quizEntity);
        QuizDTO resQuizDTO=modelMapper.map(quizEntity,QuizDTO.class);
        return modelMapper.map(resQuizDTO,QuizResponseDTO.class);
    }

    @Override
    public List<QuestionResponseDTO> getQuiz(Integer id) throws QuizException {
        Optional<QuizEntity> quizOptional = quizRepository.findById(id);
        List<QuestionDTO> listOfQuestonDTO= quizOptional.map(quizEntity -> quizEntity.getQuestions().stream()
                        .map((questionEntity)-> modelMapper.map(questionEntity,QuestionDTO.class))
                        .collect(Collectors.toList())
        ).orElseThrow(()-> new QuizException("Quiz Not Found!!"));
        return listOfQuestonDTO.stream()
                .map(questionDTO -> modelMapper.map(questionDTO, QuestionResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteQuiz(Integer quizid) throws QuizException {
        quizRepository.findById(quizid).orElseThrow(()-> new QuizException("No Quiz found for this id"));
        quizRepository.deleteById(quizid);
    }

    @Override
    public QuizResponseDTO updateQuiz(QuizDTO quizDTO) {
        QuizEntity quizEntity=modelMapper.map(quizDTO,QuizEntity.class);
        quizEntity.getQuestions().forEach((question)->question.setQuiz(quizEntity));
        quizRepository.save(quizEntity);
        return modelMapper.map(quizDTO,QuizResponseDTO.class);
    }
}
