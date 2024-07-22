package com.jolipjo.lovebridge.domain.board.controller;

import com.jolipjo.lovebridge.domain.board.dto.BoardEditDTO;
import com.jolipjo.lovebridge.domain.board.dto.BoardNoticeDTO;
import com.jolipjo.lovebridge.domain.board.dto.BoardViewDTO;
import com.jolipjo.lovebridge.domain.board.dto.BoardWriteDTO;
import com.jolipjo.lovebridge.domain.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board/")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("notice")
    public String boardNotice(Model model) {

        BoardNoticeDTO boardNoticeDTO = new BoardNoticeDTO();

        List<BoardNoticeDTO> boardList = boardService.getBoardList(boardNoticeDTO);
        model.addAttribute("boardList", boardList);

        return "html/board/notice/board-notice";

    }

    @GetMapping("notice/{id}")
    public String boardNoticeView(@PathVariable("id") int id, Model model) {

        BoardViewDTO boardViewDTO = new BoardViewDTO();

//        String postTitle = boardService.getBoardViewTitle(boardViewDTO);
//        model.addAttribute("postTitle", postTitle);
//
//        String postText = boardService.getBoardViewText(boardViewDTO);
//        model.addAttribute("postText", postText);
        return "html/board/notice/board-notice-view";
    }

    @GetMapping("notice/write")
    public String boardNoticeWrite(Model model) {

        BoardWriteDTO boardWriteDTO = new BoardWriteDTO();
        boardWriteDTO.setTitle("이것은 제목입니다.");
        boardWriteDTO.setText("이것은 내용입니다.");

        model.addAttribute("message", boardWriteDTO);

        return "html/board/notice/board-notice-write";
    }

    @GetMapping("notice/edit")
    public String boardNoticeEditGet(Model model) {

        BoardEditDTO boardEditDTO = new BoardEditDTO();

//        List<BoardEditDTO> boardText = boardService.getBoardText(boardEditDTO);

        boardEditDTO.getTitle();
        boardEditDTO.getText();

        model.addAttribute("message", boardEditDTO);


        return "html/board/notice/board-notice-edit";
    }

    @PostMapping("notice/edit")
    public String boardNoticeEditPost(Model model) {

        BoardEditDTO boardEditDTO = new BoardEditDTO();

        return "redirect:/board/notice";

    }

    @PostMapping("notice/write")
    public String boardNoticeWrite(BoardWriteDTO newPost) {

        boardService.writeNewPost(newPost);
        return "html/board/notice/board-notice-write";
    }

//    @GetMapping("notice/{id}")
//    public String deleteBoardNotice(@PathVariable("id") int id, Model model) {
//
//    }
}
