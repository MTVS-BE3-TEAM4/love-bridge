package com.jolipjo.lovebridge.domain.quiz.dto;

import java.util.ArrayList;

public class QuizListResponseDTO {

    private int quizId;
    private String quizTitle;
    private String quizComplete;

    public QuizListResponseDTO() {}

    public QuizListResponseDTO(int quizId, String quizTitle, String quizComplete) {
        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.quizComplete = quizComplete;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public String getComplete() {
        return quizComplete;
    }

    public void setComplete(String complete) {
        quizComplete = complete;
    }

    @Override
    public String toString() {
        return "QuizListResponseDTO{" +
                "quizId=" + quizId +
                ", quizTitle='" + quizTitle + '\'' +
                ", quizComplete=" + quizComplete +
                '}';
    }
}
