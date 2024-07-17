package com.jolipjo.lovebridge.domain.quiz.controller;

import com.jolipjo.lovebridge.domain.quiz.dto.Quiz;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizDetail;
import com.jolipjo.lovebridge.domain.quiz.dto.QuizDetailRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    @GetMapping("")
    public String boardQna(Model model) {
        return "html/quiz/quiz-list";
    }

//    @GetMapping("/{id}")
//    public String boardQnaView(@PathVariable("id") Long id, Model model) {
    @GetMapping("/test")
    public String boardQnaView(Model model) {
        QuizDetail quizDetail = new QuizDetail();

        quizDetail.setImgSrc("https://dummyimage.com/600x600/8aff82/fff");
        quizDetail.setAnswer("testtestetest");


        model.addAttribute("imgSrc", quizDetail.getImgSrc());

        return "html/quiz/quiz-view";
    }

    @PostMapping("/test")
    public String boardQnaSubmit(@ModelAttribute("QuizDetailRequestDTO") QuizDetailRequestDTO quizDetailRequestDTO) {

        System.out.println(quizDetailRequestDTO.getQuizAnswer());

        return "html/quiz/quiz-view";
    }
}
