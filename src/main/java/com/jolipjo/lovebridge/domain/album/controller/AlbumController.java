package com.jolipjo.lovebridge.domain.album.controller;

import com.jolipjo.lovebridge.common.FileUploader;
import com.jolipjo.lovebridge.domain.album.dto.*;
import com.jolipjo.lovebridge.domain.album.service.AlbumService;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {


    private final AlbumService albumService;
//    private final MessageSource messageSource;
//    private final FileUploader fileUploader;


    @Autowired
    public AlbumController(AlbumService albumService, FileUploader fileUploader) {
        this.albumService = albumService;
//        this.fileUploader = fileUploader;
    }

    // 앨범 화면 불러오기
    @GetMapping
    public String albumListPage(Model model) {

        List<AlbumListResponseDTO> albumListResponseDTOS = albumService.albumListPage();
        System.out.println(albumListResponseDTOS);
        model.addAttribute("albumList", albumListResponseDTOS);




        return "html/album/album-list";
    }




    @PostMapping("{id}")
    public ResponseEntity<Void> albumDelete(@PathVariable int id, AlbumDeleteDTO albumDeleteDTO) {
        albumService.albumDelete(albumDeleteDTO, id);
        return ResponseEntity.noContent().build(); // Return HTTP 204 No Content
    }

    //3. 앨범 작성 화면 호출
    @GetMapping("write")
    public String albumWritePage() {
        System.out.println("작성화면 호출");

        return "html/album/album-write";
    }


    //4. 앨범 작성 하기
    @PostMapping("write")
    public String albumWrite(AlbumWriteRequestDTO albumWriteRequestDTO, Model model) {

        albumService.albumWrite(albumWriteRequestDTO);
        System.out.println(albumWriteRequestDTO);



        return "redirect:/album";
    }


    //5.수정 값 가져오기
    @GetMapping("modify/{id}")
    public String albumModifyLoad( @PathVariable Long id, Model model) {

        AlbumModifyRequestDTO albumModify = albumService.albumModifyLoad(id);
        model.addAttribute("albumModify", albumModify);


        System.out.println("수정 페이지 호출");
        System.out.println(albumModify);

        return "html/album/album-modify";
    }


    //6.수정 값 보내기
    @PostMapping("modify/{id}")
    public String albumModifySend(@PathVariable Long id, AlbumModifyResponseDTO albumModifyResponseDTO) {
        albumModifyResponseDTO.setId(id);
        albumService.albumModifySend(albumModifyResponseDTO);


        return "redirect:/album";
    }

}























