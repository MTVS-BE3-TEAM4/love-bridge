package com.jolipjo.lovebridge.domain.album.service;


import com.jolipjo.lovebridge.common.FileUploader;
import com.jolipjo.lovebridge.domain.album.dao.AlbumMapper;
import com.jolipjo.lovebridge.domain.album.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;


import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AlbumService {

    private final AlbumMapper albumMapper;
    private final FileUploader fileUploader;
    private static final String ERROR_MESSAGE = " 내용은 200글자를 초과할 수 없습니다";


    public AlbumService(AlbumMapper albumMapper, FileUploader fileUploader) {
        this.albumMapper = albumMapper;
        this.fileUploader = fileUploader;
    }


    //화면 출력
    public List<AlbumListResponseDTO> albumListPage(long memberId, int page, int size) {
        //page*=size;
        int offset = (page - 1) * size;
        return albumMapper.albumListPage(memberId, size, page);
    }

    //페이징
    public int getTotatlItem(long memberId) {
        return albumMapper.getTotalItem(memberId);
    }


    //앨범 삭제
    public void albumDelete(AlbumDeleteDTO albumDeleteDTO, int id) {
        albumMapper.albumDelete(albumDeleteDTO, id);
    }


    //앨범 작성하기
    @Transactional
    public void albumWrite(AlbumWriteRequestDTO albumWriteRequestDTO) {

        albumMapper.albumWrite(albumWriteRequestDTO);
    }


    //앨범 수정 값 불러오기
    public AlbumModifyRequestDTO albumModifyLoad(long id) {
        return albumMapper.albumModifyLoad(id);
    }


    //앨범 수정 값 보내기
    @Transactional
    public void albumModifySend(AlbumModifyResponseDTO albumModifyResponseDTO) {
        System.out.println("albumModifyResponseDTO = " + albumModifyResponseDTO);
        albumMapper.albumModifySend(albumModifyResponseDTO);
    }


}






//    //바이트수 측정 메서드
//    public static int getLenght(String str) throws UnsupportedEncodingException {
//        if (str == null) {
//            return 0;
//        }
//        return str.getBytes("UTF-8").length;
//    }
//
//    private void validate(AlbumModifyResponseDTO dto , BindingResult bindingResult) throws UnsupportedOperationException {
//
//
//            String memo = dto.getMemo();
//
//            if (memo != null && getLenght(memo) > 200){
//                bindingResult.rejectValue("memo","error.memo",ERROR_MESSAGE);
//            }
//
//
//
//    }
//
//
//
//
//
//}
