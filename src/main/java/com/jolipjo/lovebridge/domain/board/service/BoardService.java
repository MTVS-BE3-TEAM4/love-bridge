package com.jolipjo.lovebridge.domain.board.service;

import com.jolipjo.lovebridge.domain.board.dao.BoardMapper;
import com.jolipjo.lovebridge.domain.board.dto.BoardEditDTO;
import com.jolipjo.lovebridge.domain.board.dto.BoardNoticeDTO;
import com.jolipjo.lovebridge.domain.board.dto.BoardViewDTO;
import com.jolipjo.lovebridge.domain.board.dto.BoardWriteDTO;
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
    public void writeNewPost(BoardWriteDTO boardWriteDTO) {
        boardMapper.writeNewMenu(boardWriteDTO);
    }

    public List<BoardNoticeDTO> getBoardList(BoardNoticeDTO boardNoticeDTO) {
        return boardMapper.getBoardList(boardNoticeDTO);
    }

    public List<BoardEditDTO> getBoardEdit(BoardEditDTO boardEditDTO) {
        return boardMapper.getBoardText(boardEditDTO);
    }

    public String getBoardViewTitle(BoardViewDTO boardViewDTO) {
        return boardMapper.getBoardViewTitle(boardViewDTO);
    }

    public String getBoardViewText(BoardViewDTO boardViewDTO) {
        return boardMapper.getBoardViewTitle(boardViewDTO);
    }
}
