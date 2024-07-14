package com.jolipjo.lovebridge.domain.quiz.dto;

public class QuizListRequestDTO {
    /*
    1. 시크릿코드
     */
    private int secret;

    public QuizListRequestDTO() {}

    public int getSecret() {
        return secret;
    }

    public void setSecret(int secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "QuizListRequestDTO{" +
                "secret=" + secret +
                '}';
    }
}
