package com.quiz.management.application.service;

import com.quiz.management.application.dto.QuestionRequestDTO;
import com.quiz.management.application.dto.QuestionResponseDTO;
import com.quiz.management.application.dto.QuizRequestDTO;
import com.quiz.management.application.entity.QuestionEntity;
import com.quiz.management.application.entity.QuizEntity;
import com.quiz.management.application.exception.QuestionException;
import com.quiz.management.application.exception.QuizException;
import com.quiz.management.application.repository.QuestionRepositry;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepositry questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuestionResponseDTO createQuestion(QuestionRequestDTO questionRequestDTO) {
        QuestionEntity questionEntity = modelMapper.map(questionRequestDTO, QuestionEntity.class);
        QuizRequestDTO quizRequestDTO = questionRequestDTO.getQuizRequestDTO();
        QuizEntity quizEntity = modelMapper.map(quizRequestDTO, QuizEntity.class);
        questionEntity.setQuiz(quizEntity);
        questionRepository.save(questionEntity);
        return modelMapper.map(questionRequestDTO, QuestionResponseDTO.class);
    }

    @Override
    public QuestionResponseDTO getQuestion(Integer id) throws QuestionException {
        QuestionEntity questionEntity = questionRepository.findById(id).orElseThrow(() -> new QuestionException("Question not found"));
        QuestionRequestDTO questionRequestDTO = modelMapper.map(questionEntity, QuestionRequestDTO.class);
        return modelMapper.map(questionRequestDTO, QuestionResponseDTO.class);
    }

    @Override
    public void deleteQuestion(Integer questionid) throws QuestionException, QuizException {
        //questionRepository.findById(questionid).orElseThrow(()-> new QuestionException("No Quiz found for this id"));
        questionRepository.deleteById(questionid);
    }

    @Override
    public QuestionResponseDTO updateQuestion(QuestionRequestDTO questionRequestDTO) {
        QuestionEntity questionEntity = modelMapper.map(questionRequestDTO, QuestionEntity.class);
        questionEntity.setQuiz(questionEntity.getQuiz());
        questionEntity.setCorrectOption(questionEntity.getCorrectOption());
        questionEntity.setDifficulty(questionEntity.getDifficulty());
        questionEntity.setCategory(questionEntity.getCategory());
        questionEntity.setOptions(questionEntity.getOptions());
        questionEntity.setDescription(questionEntity.getDescription());
        questionRepository.save(questionEntity);
        return modelMapper.map(questionRequestDTO, QuestionResponseDTO.class);
    }
}
