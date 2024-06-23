package com.quiz.management.application.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizRequestDTO {
    private Integer id;
    @NotEmpty(message = "Quiz category is mandatory")
    private String category;
    private List<QuestionRequestDTO> questions;

//    @Override
//    public String toString() {
//        return "QuizRequestDTO{" +
//                "id=" + id +
//                ", category='" + category + '\'' +
//                ", questions=" + questions +
//                '}';
//    }
}
