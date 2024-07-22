package com.jolipjo.lovebridge.domain.quiz.dto;

import java.util.Date;

public class QuizDetail {
    /*
    1.회원ID
    2.프로필 사진 이미지 경로
    3.답변내용
    4.작성날짜
     */

    private String quizTitle;

    public QuizDetail() {}

    public QuizDetail(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    @Override
    public String toString() {
        return "QuizDetail{" +
                "quizTitle='" + quizTitle + '\'' +
                '}';
    }
}
