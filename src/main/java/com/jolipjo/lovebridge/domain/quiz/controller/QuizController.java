package com.jolipjo.lovebridge.domain.quiz.controller;

import com.jolipjo.lovebridge.domain.quiz.dto.*;
import com.jolipjo.lovebridge.domain.quiz.service.QuizService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;
    private final MessageSource messageSource;

    public QuizController(QuizService quizService, MessageSource messageSource) {
        this.quizService = quizService;
        this.messageSource = messageSource;
    }
    @GetMapping
    public String quizGetList(Model model) {

        List<QuizListResponseDTO> quizList = quizService.getQuizList();
        model.addAttribute("quizList", quizList);

        return "html/quiz/quiz-list";
    }

//    @GetMapping("/{id}")
//    public String boardQnaView(@PathVariable("id") Long id, Model model) {
    @GetMapping("/test")
    public String boardQnaView(Model model) {
        QuizDetail quizDetail = new QuizDetail();

        quizDetail.setImgSrc("https://dummyimage.com/600x600/8aff82/fff");
        quizDetail.setAnswer("test");


        model.addAttribute("imgSrc", quizDetail.getImgSrc());

        return "html/quiz/quiz-view";
    }

    @PostMapping("/test")
    public String boardQnaSubmit(@ModelAttribute("QuizDetailRequestDTO") QuizDetailRequestDTO quizDetailRequestDTO) {

        System.out.println(quizDetailRequestDTO.getQuizAnswer());

        return "html/quiz/quiz-view";
    }
}
