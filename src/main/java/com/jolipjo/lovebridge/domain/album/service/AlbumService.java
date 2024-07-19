package com.jolipjo.lovebridge.domain.album.service;


import com.jolipjo.lovebridge.domain.album.dao.AlbumMapper;
import com.jolipjo.lovebridge.domain.album.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumMapper  albumMapper;

    public AlbumService(AlbumMapper albumMapper) {this.albumMapper = albumMapper;}



    //화면 출력
    public List<AlbumListResponseDTO> albumListPage() {
        return albumMapper.albumListPage();
    }

    //앨범 삭제
    public void albumDelete(AlbumDeleteDTO albumDeleteDTO,int id) {
        albumMapper.albumDelete(albumDeleteDTO,id);
    }


    //앨범 작성하기
    public void albumWrite(AlbumWriteRequestDTO albumWriteRequestDTO) {
        albumMapper.albumWrite(albumWriteRequestDTO);
    }


    //앨범 수정 값 불러오기
    public AlbumModifyResponseDTO albumModifyLoad(int id) {
        return albumMapper.albumModifyLoad(id);
    }


    //앨범 수정 값 보내기
    public void albumModifySend(AlbumModifyRequestDTO albumModifyRequestDTO ) {
        albumMapper.albumModifySend(albumModifyRequestDTO);
    }



}
