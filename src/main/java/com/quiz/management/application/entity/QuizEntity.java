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
@Table(name = "quiz")
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Integer id;
    @Column(name = "category")
    private String category;
    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<QuestionEntity> questions;

    @Override
    public String toString() {
        return "QuizEntity{" +
                "id=" + id +
                ", category='" + category +
                '}';
    }
}
