package com.jolipjo.lovebridge.domain.quiz.dto;

import java.time.LocalDateTime;

public class QuizDetailAnswerRequestDTO {
    private String quizAnswer;
//    private LocalDateTime createdAt;
    private Long quizId;
    private Long quizNum;


    public String getQuizAnswer() {
        return quizAnswer;
    }

    public void setQuizAnswer(String quizAnswer) {
        this.quizAnswer = quizAnswer;
    }

    public long getQuizId() {
        return quizId;
    }

    public void setQuizId(long quizId) {
        this.quizId = quizId;
    }

    public long getQuizNum() {
        return quizNum;
    }

    public void setQuizNum(long quizNum) {
        this.quizNum = quizNum;
    }
}
