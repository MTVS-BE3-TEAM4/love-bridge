package com.jolipjo.lovebridge.domain.quiz.dto;

public class QuizAnswerPKParameter {

    private Long quizId;
    private Long coupleId;
    private Long quizNum;

    public QuizAnswerPKParameter(Long quizId, Long coupleId, Long quizNum) {
        this.coupleId = coupleId;
        this.quizId = quizId;
        this.quizNum = quizNum;
    }

    public Long getCoupleId() {
        return coupleId;
    }

    public void setCoupleId(Long coupleId) {
        this.coupleId = coupleId;
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
