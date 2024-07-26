package com.jolipjo.lovebridge.domain.quiz.dto;

import com.jolipjo.lovebridge.domain.paginaition.dto.PaginationDTO;

import java.util.ArrayList;

public class QuizListResponseDTO {

    private Long quizId;
    private Long quizNum;
    private Long coupleId;
    private String quizTitle;
    private String quizComplete;

    public QuizListResponseDTO() {}

    public QuizListResponseDTO(Long quizId, Long quizNum, Long coupleId, String quizTitle, String quizComplete) {
        this.quizId = quizId;
        this.quizNum = quizNum;
        this.coupleId = coupleId;
        this.quizTitle = quizTitle;
        this.quizComplete = quizComplete;
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

    public String getQuizTitle() {
        return quizTitle;
    }

    public Long getCoupleId() {
        return coupleId;
    }

    public void setCoupleId(Long coupleId) {
        this.coupleId = coupleId;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public String getQuizComplete() {
        return quizComplete;
    }

    public void setQuizComplete(String quizComplete) {
        this.quizComplete = quizComplete;
    }

    @Override
    public String toString() {
        return "QuizListResponseDTO{" +
                "quizId=" + quizId +
                ", quizNum=" + quizNum +
                ", coupleId=" + coupleId +
                ", quizTitle='" + quizTitle + '\'' +
                ", quizComplete='" + quizComplete + '\'' +
                '}';
    }
}
