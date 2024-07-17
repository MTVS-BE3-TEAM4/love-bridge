package com.jolipjo.lovebridge.domain.quiz.dto;

public class QuizDetailRequestDTO {

    private String quizAnswer;

    public QuizDetailRequestDTO() {}

    public QuizDetailRequestDTO(String quizAnswer) {
        this.quizAnswer = quizAnswer;
    }

    public String getQuizAnswer() {
        return quizAnswer;
    }

    public void setQuizAnswer(String quizAnswer) {
        this.quizAnswer = quizAnswer;
    }

    @Override
    public String toString() {
        return "QuizDetailRequestDTO{" +
                "quizAnswer='" + quizAnswer + '\'' +
                '}';
    }
}
