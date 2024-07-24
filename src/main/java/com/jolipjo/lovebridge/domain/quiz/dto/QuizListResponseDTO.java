package com.jolipjo.lovebridge.domain.quiz.dto;

import java.util.ArrayList;

public class QuizListResponseDTO {

    private Long quizId;
    private String quizTitle;
    private String quizComplete;
    private int secretCode;

    public QuizListResponseDTO() {}

    public QuizListResponseDTO(Long quizId, String quizTitle, String quizComplete, int secretCode) {
        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.quizComplete = quizComplete;
        this.secretCode = secretCode;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public String getQuizComplete() {
        return quizComplete;
    }

    public void setQuizComplete(String quizComplete) {
        this.quizComplete = quizComplete;
    }

    public int getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(int secretCode) {
        this.secretCode = secretCode;
    }

    @Override
    public String toString() {
        return "QuizListResponseDTO{" +
                "quizId=" + quizId +
                ", quizTitle='" + quizTitle + '\'' +
                ", quizComplete='" + quizComplete + '\'' +
                ", secretCode=" + secretCode +
                '}';
    }
}
