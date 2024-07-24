package com.jolipjo.lovebridge.domain.album.service;


import com.jolipjo.lovebridge.common.FileUploader;
import com.jolipjo.lovebridge.domain.album.dao.AlbumMapper;
import com.jolipjo.lovebridge.domain.album.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumMapper  albumMapper;
    private final FileUploader fileUploader;

    public AlbumService(AlbumMapper albumMapper, FileUploader fileUploader) {
        this.albumMapper = albumMapper;
        this.fileUploader = fileUploader;
    }


    //화면 출력
    public List<AlbumListResponseDTO> albumListPage(long memberId) {
        return albumMapper.albumListPage(memberId);
    }

    //앨범 삭제
    public void albumDelete(AlbumDeleteDTO albumDeleteDTO,int id) {
        albumMapper.albumDelete(albumDeleteDTO,id);
    }


    //앨범 작성하기
    @Transactional
    public void albumWrite(AlbumWriteRequestDTO albumWriteRequestDTO) {
        albumMapper.albumWrite(albumWriteRequestDTO);
    }
//    public List<AlbumWriteRequestDTO> albumWrite(Long memberId) {
//        return albumMapper.albumWrite(memberId);
//    }


    //앨범 수정 값 불러오기
    public AlbumModifyRequestDTO albumModifyLoad(long id) {
        return albumMapper.albumModifyLoad(id);
    }


    //앨범 수정 값 보내기
    @Transactional
    public void albumModifySend(AlbumModifyResponseDTO albumModifyResponseDTO ) {
        System.out.println("albumModifyResponseDTO = " + albumModifyResponseDTO);
        albumMapper.albumModifySend(albumModifyResponseDTO);
    }




//    public List<AlbumListResponseDTO> albumId(Long memberId) {
//        return albumMapper.albumId(memberId);
//    }
}
