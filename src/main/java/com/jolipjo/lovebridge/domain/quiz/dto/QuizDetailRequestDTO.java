package com.jolipjo.lovebridge.domain.quiz.dto;

public class QuizDetailRequestDTO {
    /*
    1. 퀴즈목록ID
     */
    private int ID;

    public QuizDetailRequestDTO() {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "QuizDetailRequestDTO{" +
                "ID=" + ID +
                '}';
    }
}
