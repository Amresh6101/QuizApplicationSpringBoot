package com.quiz.management.application.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "question")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer id;
    @Column(name = "category")
    private String category;
    @Column(name = "description")
    private String description;
    private List<String> options;
    @Column(name = "correct_option")
    private Integer correctOption;
    @Column(name = "difficulty")
    private String difficulty;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private QuizEntity quiz;

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", options=" + options +
                ", correctOption=" + correctOption +
                ", difficulty='" + difficulty +
                '}';
    }
}
