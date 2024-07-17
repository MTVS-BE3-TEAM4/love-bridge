package com.jolipjo.lovebridge.domain.quiz.dto;

import java.util.ArrayList;

public class QuizListResponseDTO {

    private int quizId;
    private String quizTitle;
    private Boolean isComplete;

    public QuizListResponseDTO() {}

    public QuizListResponseDTO(int quizId, String quizTitle, Boolean isComplete) {
        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.isComplete = isComplete;
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

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return "QuizListResponseDTO{" +
                "quizId=" + quizId +
                ", quizTitle='" + quizTitle + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
}
