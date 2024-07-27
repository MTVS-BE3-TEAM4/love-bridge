package com.jolipjo.lovebridge.domain.quiz.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class QuizDetailAnswerResponseDTO {

    private String quizAnswer;
    private LocalDateTime createdAt;

    private Long quizId;
    private Long quizNum;
    private String title;
    private Long memberId;

    public QuizDetailAnswerResponseDTO(String quizAnswer, LocalDateTime createdAt, Long quizId, Long quizNum, String title, Long memberId) {
        this.createdAt = createdAt;
        this.quizAnswer = quizAnswer;
        this.quizId = quizId;
        this.quizNum = quizNum;
        this.title = title;
        this.memberId = memberId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getQuizAnswer() {
        return quizAnswer;
    }

    public void setQuizAnswer(String quizAnswer) {
        this.quizAnswer = quizAnswer;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getQuizNum() {
        return quizNum;
    }

    public void setQuizNum(Long quizNum) {
        this.quizNum = quizNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
