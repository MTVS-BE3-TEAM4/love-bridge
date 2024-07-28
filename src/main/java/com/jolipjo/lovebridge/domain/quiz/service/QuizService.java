package com.jolipjo.lovebridge.domain.quiz.service;

import com.jolipjo.lovebridge.domain.quiz.dao.QuizMapper;
import com.jolipjo.lovebridge.domain.quiz.dto.*;
import com.jolipjo.lovebridge.domain.quiz.entity.QuizAnswer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizService {

    private final QuizMapper quizMapper;

    public QuizService(QuizMapper quizMapper) {
        this.quizMapper = quizMapper;
    }

    public List<QuizListResponseDTO> getQuizList(Long id) {

        List<QuizListResponseDTO> quizList = quizMapper.getQuizList(id);

        return quizList;
    }

    public List<QuizDetailAnswerResponseDTO> getQuizDetail(Long quizId, Long coupleId, Long quizNum) {
        QuizAnswerPKParameter quizAnswerPKParameter = new QuizAnswerPKParameter(
                quizId, coupleId, quizNum
        );

        return quizMapper.getQuizDetail(quizAnswerPKParameter);
    }

    @Transactional
    public void registAnswer(
            QuizDetailAnswerRequestDTO quizDetailAnswerRequestDTO,
            Long coupleId,
            Long memberId) {
        QuizAnswer quizAnswer = new QuizAnswer(
                quizDetailAnswerRequestDTO.getQuizAnswer(),
                LocalDateTime.now(),
                quizDetailAnswerRequestDTO.getQuizId(),
                coupleId,
                quizDetailAnswerRequestDTO.getQuizNum(),
                memberId
        );

        quizMapper.registAnswer(quizAnswer);
    }

    @Transactional
    public void quizAdd(Long coupleId) {
        quizMapper.quizAdd(coupleId);
    }

    public String getOneQuizTitle(Long quizId) {
        return quizMapper.getOneQuiz(quizId);
    }

    public void updateIsQuizComplete(Long coupleId, Long quizId, Long quizNum) {
        quizMapper.updateIsQuizComplete(new QuizAnswerPKParameter(quizId, coupleId, quizNum));
    }

}
