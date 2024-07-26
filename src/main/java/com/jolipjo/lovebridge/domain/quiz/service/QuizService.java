package com.jolipjo.lovebridge.domain.quiz.service;

import com.jolipjo.lovebridge.domain.quiz.dao.QuizMapper;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizDetailAnswer;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizListResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public String getQuizDetail(Long id) {
        return quizMapper.getQuizDetail(id);
    }

    @Transactional
    public void registAnswer(QuizDetailAnswer quizDetailAnswer) {
        quizMapper.registAnswer(quizDetailAnswer);
    }

    @Transactional
    public void quizAdd(Long coupleId) {
        quizMapper.quizAdd(coupleId);
    }


//    public String getImgSrc() {
//        return quizMapper.getImgSrc();
//    }
}
