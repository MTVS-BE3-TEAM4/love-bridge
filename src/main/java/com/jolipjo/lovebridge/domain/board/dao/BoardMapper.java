package com.jolipjo.lovebridge.domain.board.dao;

import com.jolipjo.lovebridge.domain.board.dto.BoardEditDTO;
import com.jolipjo.lovebridge.domain.board.dto.BoardNoticeDTO;
import com.jolipjo.lovebridge.domain.board.dto.BoardViewDTO;
import com.jolipjo.lovebridge.domain.board.dto.BoardWriteDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardNoticeDTO> getBoardList(BoardNoticeDTO boardNoticeDTO);

    List<BoardEditDTO> getBoardText(BoardEditDTO boardEditDTO);

    void writeNewMenu(BoardWriteDTO boardWriteDTO);

    String getBoardViewTitle(BoardViewDTO boardViewDTO);

    String getBoardTitle(BoardViewDTO boardViewDTO);
}
