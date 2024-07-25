package com.jolipjo.lovebridge.domain.board.dao;

import com.jolipjo.lovebridge.domain.board.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardNoticeDTO> getBoardList(BoardNoticeDTO boardNoticeDTO);


    void writeNewPost(BoardWriteDTO newPost);

    String getBoardViewTitle(BoardViewDTO boardViewDTO);


    String getBoardViewText(BoardViewDTO boardViewDTO);


    BoardViewDTO getBoardView(int id);

    BoardEditDTO getBoardEdit(int id);

    void boardModify(BoardEditDTO boardEditDTO);


    void boardDelete(BoardDeleteDTO boardDeleteDTO, int id);

    List<BoardNoticeDTO> getBoardListPage(BoardPageDTO boardPageDTO);

    int countBoardList();
}