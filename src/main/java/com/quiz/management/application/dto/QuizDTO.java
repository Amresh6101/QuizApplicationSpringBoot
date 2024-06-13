package com.quiz.management.application.dto;

import com.quiz.management.application.entity.QuestionEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {
    private Integer id;
    @NotEmpty(message = "Quiz category is mandatory")
    private String category;
    private List<QuestionDTO> questions;
}
