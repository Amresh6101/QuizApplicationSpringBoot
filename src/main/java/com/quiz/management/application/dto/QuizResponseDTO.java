package com.quiz.management.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponseDTO {
    private Integer id;
    private String category;
    private List<QuestionResponseDTO> questions;
}
