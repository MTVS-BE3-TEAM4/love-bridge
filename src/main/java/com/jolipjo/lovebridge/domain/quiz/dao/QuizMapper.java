package com.jolipjo.lovebridge.domain.quiz.dao;

import com.jolipjo.lovebridge.domain.quiz.dto.*;
import com.jolipjo.lovebridge.domain.quiz.entity.QuizAnswer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuizMapper {
    List<QuizListResponseDTO> getQuizList(Long id);

    List<QuizDetailAnswerResponseDTO> getQuizDetail(QuizAnswerPKParameter quizAnswerPKParameter);

    void registAnswer(QuizAnswer quizAnswer);

    void quizAdd(Long coupleId);

    int countTotalItems();

    String getOneQuiz(Long quizId);

    void updateIsQuizComplete(QuizAnswerPKParameter quizAnswerPKParameter);
}
