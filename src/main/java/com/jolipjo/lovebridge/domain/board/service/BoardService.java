package com.jolipjo.lovebridge.domain.board.service;

import com.jolipjo.lovebridge.domain.board.dao.BoardMapper;
import com.jolipjo.lovebridge.domain.board.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Transactional
    public void writeNewPost(BoardWriteDTO newPost) {
        boardMapper.writeNewPost(newPost);
    }

    public List<BoardNoticeDTO> getBoardList(BoardNoticeDTO boardNoticeDTO) {
        return boardMapper.getBoardList(boardNoticeDTO);
    }

    public String getBoardViewText(BoardViewDTO boardViewDTO) {
        return boardMapper.getBoardViewText(boardViewDTO);
    }

    public BoardViewDTO getBoardView(int id) {
        return boardMapper.getBoardView(id);
    }

    public BoardEditDTO getBoardEdit(int id) {
        return boardMapper.getBoardEdit(id);
    }

    public void boardModify(BoardEditDTO boardEditDTO) {
        boardMapper.boardModify(boardEditDTO);
    }

    public void boardDelete(BoardDeleteDTO boardDeleteDTO) {
        boardMapper.boardDelete(boardDeleteDTO);
    }

    public List<BoardNoticeDTO> getBoardListPage(BoardPageDTO boardPageDTO) {
        return boardMapper.getBoardListPage(boardPageDTO);
    }

    public int countBoardList() {
        return boardMapper.countBoardList();
    }
}
