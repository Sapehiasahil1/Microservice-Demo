package com.sapehia.quiz_service.model;

import lombok.Data;

@Data
public class QuizDto {
    String categoryName;
    int questionCount;
    String title;
}
