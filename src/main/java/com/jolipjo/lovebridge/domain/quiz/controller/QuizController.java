package com.jolipjo.lovebridge.domain.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    @GetMapping("")
    public String boardQna(Model model) {
        return "html/quiz/quiz-list";
    }

    @GetMapping("/{id}")
    public String boardQnaView(@PathVariable("id") Long id, Model model) {
        return "html/quiz/quiz-view";
    }
}
