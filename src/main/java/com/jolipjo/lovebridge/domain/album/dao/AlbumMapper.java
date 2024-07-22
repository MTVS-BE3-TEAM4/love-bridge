package com.jolipjo.lovebridge.domain.album.dao;


import com.jolipjo.lovebridge.domain.album.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlbumMapper {



    //앨범 화면 불러오기
    List<AlbumListResponseDTO> albumListPage();


    //삭제하기
    void albumDelete(AlbumDeleteDTO albumDeleteDTO,int id);


    //앨범 작성하기
    void albumWrite(AlbumWriteRequestDTO albumWriteRequestDTO);


    //앨범 수정 값 불러오기
    AlbumModifyRequestDTO albumModifyLoad(long id);


    //앨범 수정 값 보내기
    void albumModifySend(AlbumModifyResponseDTO albumModifyResponseDTO);



}

