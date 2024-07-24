package com.jolipjo.lovebridge.domain.quiz.service;

import com.jolipjo.lovebridge.domain.quiz.dao.QuizMapper;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizDetailAnswer;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizListResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuizService {

    private final QuizMapper quizMapper;

    public QuizService(QuizMapper quizMapper) {
        this.quizMapper = quizMapper;
    }

    public List<QuizListResponseDTO> getQuizList() {

        List<QuizListResponseDTO> quizList = quizMapper.getQuizList();
        List<QuizListResponseDTO> subset = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < quizList.size(); i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);

        int count = 0;

        for (Integer index : indices) {
//            if (count >= subsetSize) {
//                break;
//            }
            QuizListResponseDTO quiz = quizList.get(index);
            if (!subset.contains(quiz)) {
                subset.add(quiz);
                count++;
            }
        }

        return subset;
    }

    public String getQuizDetail(Long id) {
        return quizMapper.getQuizDetail(id);
    }

    @Transactional
    public void registAnswer(QuizDetailAnswer quizDetailAnswer) {
        quizMapper.registAnswer(quizDetailAnswer);
    }

//    public String getImgSrc() {
//        return quizMapper.getImgSrc();
//    }
}
