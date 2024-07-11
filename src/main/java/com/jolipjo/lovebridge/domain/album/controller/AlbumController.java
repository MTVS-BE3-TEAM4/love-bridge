package com.jolipjo.lovebridge.domain.album.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @GetMapping
    public String albumListPage(Model model) {
        return "html/album/album-list";
    }

    @GetMapping("/write")
    public String albumWritePage(Model model) {

        return "html/album/album-write";
    }
}