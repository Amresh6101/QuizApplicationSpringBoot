package com.quiz.management.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDTO {
        @NotNull
        private Integer id;
        private String category;
        private String description;
        private List<String> options;
        private Integer correctOption;
        private String difficulty;
}
