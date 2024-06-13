package com.quiz.management.application.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Integer id;
    private String category;
    private String description;
    private List<String> options;
    private Integer correctOption;
    private String difficulty;
    private QuizDTO quizDTO;
}
