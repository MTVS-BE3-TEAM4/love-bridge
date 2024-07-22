package com.jolipjo.lovebridge.domain.quiz.controller;

import com.amazonaws.internal.SdkFilterOutputStream;
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
    @GetMapping("/{id}")
    public String quizDetailView(@PathVariable("id") int id, Model model) {

//        String message = quizService.getMsg(id);

        String quizGetTitle = quizService.getQuizDetail(id);

        model.addAttribute("quizGetTitle", quizGetTitle);

        return "html/quiz/quiz-view";
    }

    @PostMapping("/{id}")
    public String quizAnswerRegist(QuizDetailAnswer quizDetailAnswer) {

        quizService.registAnswer(quizDetailAnswer);

        return "html/quiz/quiz-view";
    }
}
