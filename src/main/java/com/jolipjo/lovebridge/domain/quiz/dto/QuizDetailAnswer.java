package com.jolipjo.lovebridge.domain.quiz.dto;

public class QuizDetailAnswer {
    private String answerMessage;

    public QuizDetailAnswer() {}

    public String getAnswerMessage() {
        return answerMessage;
    }

    public void setAnswerMessage(String answerMessage) {
        this.answerMessage = answerMessage;
    }

    @Override
    public String toString() {
        return "QuizDetailAnswer{" +
                "answerMessage='" + answerMessage + '\'' +
                '}';
    }
}