package com.jolipjo.lovebridge.domain.quiz.entity;

import java.time.LocalDateTime;

public class QuizAnswer {
    private String quizAnswer;
    private LocalDateTime createdAt;
    private Long quizId;
    private Long coupleId;
    private Long quizNum;
    private Long memberId;

    public QuizAnswer(String quizAnswer, LocalDateTime createdAt, Long quizId, Long coupleId, Long quizNum, Long memberId) {
        this.coupleId = coupleId;
        this.createdAt = createdAt;
        this.memberId = memberId;
        this.quizAnswer = quizAnswer;
        this.quizId = quizId;
        this.quizNum = quizNum;
    }

    public Long getCoupleId() {
        return coupleId;
    }

    public void setCoupleId(Long coupleId) {
        this.coupleId = coupleId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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
}