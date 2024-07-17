package com.jolipjo.lovebridge.domain.quiz.dto;

import java.util.Date;

public class QuizDetail {
    /*
    1.회원ID
    2.프로필 사진 이미지 경로
    3.답변내용
    4.작성날짜
     */

    private String userId;
    private String imgSrc;
    private String answer;
    private Date answerDate;

    public void QuizDetailRequestDTO() {}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    @Override
    public String toString() {
        return "QuizDetailResponseDTO{" +
                "imgSrc='" + imgSrc + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
