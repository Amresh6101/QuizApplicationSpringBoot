package com.quiz.management.application.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequestDTO {
    private Integer id;
    private String category;
    private String description;
    private List<String> options;
    private Integer correctOption;
    private String difficulty;
    private QuizRequestDTO QuizRequestDTO;

//    @Override
//    public String toString() {
//        return "QuestionRequestDTO{" +
//                "id=" + id +
//                ", category='" + category + '\'' +
//                ", description='" + description + '\'' +
//                ", options=" + options +
//                ", correctOption=" + correctOption +
//                ", difficulty='" + difficulty + '\'' +
//                ", QuizRequestDTO=" + QuizRequestDTO +
//                '}';
//    }
}
