package com.quiz.management.application.service;

import com.quiz.management.application.dto.QuestionDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.dto.QuizDTO;
import com.quiz.management.application.entity.QuestionEntity;
import com.quiz.management.application.entity.QuizEntity;
import com.quiz.management.application.exception.QuestionException;
import com.quiz.management.application.repository.QuestionRepositry;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepositry questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionResponseDTO createQuestion(QuestionDTO questionDTO) {
        QuestionEntity questionEntity=modelMapper.map(questionDTO,QuestionEntity.class);
        QuizDTO quizDTO=questionDTO.getQuizDTO();
        QuizEntity quizEntity=modelMapper.map(quizDTO,QuizEntity.class);
        questionEntity.setQuiz(quizEntity);
        questionRepository.save(questionEntity);
        return modelMapper.map(questionDTO,QuestionResponseDTO.class);
    }

    @Override
    public QuestionResponseDTO getQuestion(Integer id) throws QuestionException {
       QuestionEntity questionEntity=questionRepository.findById(id).orElseThrow(()-> new QuestionException("Question not found"));
       QuestionDTO questionDTO=modelMapper.map(questionEntity,QuestionDTO.class);
       return  modelMapper.map(questionDTO,QuestionResponseDTO.class);
    }

    @Override
    @Transactional
    public void deleteQuestion(Integer questionid) throws QuestionException {
        // we have to work on it
        //QuestionEntity questionEntity=questionRepository.findById(questionid).orElseThrow(()-> new QuestionException("Sorry No Question available for this id"));
        //System.out.println(questionEntity);
       questionRepository.deleteById(questionid);

    }

    @Override
    public QuestionResponseDTO updateQuestion(QuestionDTO questionDTO) {
        QuestionEntity questionEntity=modelMapper.map(questionDTO,QuestionEntity.class);
        questionEntity.setQuiz(questionEntity.getQuiz());
        questionEntity.setCorrectOption(questionEntity.getCorrectOption());
        questionEntity.setDifficulty(questionEntity.getDifficulty());
        questionEntity.setCategory(questionEntity.getCategory());
        questionEntity.setOptions(questionEntity.getOptions());
        questionEntity.setDescription(questionEntity.getDescription());
        questionRepository.save(questionEntity);
        return  modelMapper.map(questionDTO,QuestionResponseDTO.class);
    }
}
