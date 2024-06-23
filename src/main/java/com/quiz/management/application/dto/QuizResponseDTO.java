package com.quiz.management.application.dto;

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

//    @Override
//    public String toString() {
//        return "QuizResponseDTO{" +
//                "id=" + id +
//                ", category='" + category + '\'' +
//                ", questions=" + questions +
//                '}';
//    }
}
