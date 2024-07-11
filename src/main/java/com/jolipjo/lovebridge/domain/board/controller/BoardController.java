package com.jolipjo.lovebridge.domain.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/")
public class BoardController {

    @GetMapping("notice")
    public String boardNotice(Model model) {
        return "html/board/notice/board-notice";
    }

    @GetMapping("notice/write")
    public String boardNoticeWrite(Model model) {
        return "html/board/notice/board-notice-write";
    }

    @GetMapping("notice/{id}")
    public String boardNoticeView(@PathVariable("id") Long id, Model model) {
        return "html/board/notice/board-notice-view";
    }
}
