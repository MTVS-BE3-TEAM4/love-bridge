package com.jolipjo.lovebridge.domain.quiz.dto;

import java.util.ArrayList;

public class QuizListResponseDTO {
    private ArrayList<Quiz> quizList;

    public QuizListResponseDTO() {}

    public QuizListResponseDTO(ArrayList<Quiz> quizList) {
        this.quizList = quizList;
    }

    public ArrayList<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(ArrayList<Quiz> quizList) {
        this.quizList = quizList;
    }

    @Override
    public String toString() {
        return "QuizListResponseDTO{" +
                "quizList=" + quizList +
                '}';
    }
}
