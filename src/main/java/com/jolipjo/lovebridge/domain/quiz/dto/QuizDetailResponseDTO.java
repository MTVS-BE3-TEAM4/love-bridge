package com.jolipjo.lovebridge.domain.quiz.dto;

import java.util.ArrayList;

public class QuizDetailResponseDTO {
    private ArrayList<QuizDetail> answerList;

    public QuizDetailResponseDTO() {}
    public QuizDetailResponseDTO(ArrayList<QuizDetail> answerList) {
        this.answerList = answerList;
    }

    public ArrayList<QuizDetail> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<QuizDetail> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "QuizDetailResponseDTO{" +
                "answerList=" + answerList +
                '}';
    }

    //    public void test() {
//
//
//        statement.setQuizListId();
//
//
//        QuizDetailResponseDTO responseDto = new QuizDetailResponseDTO();
//
//        ArrayList<?> result = db.getQuizDetail(statement, a, a );
//        for(int i = 0, len = result.length; i < len; i++) {
//
//            QuizDetail quizDetail = new QuizDetail();
//            quizDetail.setUserId( result.get(i).getUserId() );
//            quizDetail.setAnswer( result.get(i).getAnswer() );
//            quizDetail.setImgSrc( result.get(i).getImgSrc() );
//
//            responseDto.add(quizDetail);
//        }
//
//        return responseDto;
//    }


}
