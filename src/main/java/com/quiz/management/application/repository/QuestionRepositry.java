package com.quiz.management.application.repository;
import com.quiz.management.application.entity.QuestionEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepositry extends CrudRepository<QuestionEntity,Integer> {
//    @Modifying
//    @Transactional
//    @Query("delete from question where question_id=?1")
//    QuestionResponseDTO deleteQuestionById(Integer id);
}
