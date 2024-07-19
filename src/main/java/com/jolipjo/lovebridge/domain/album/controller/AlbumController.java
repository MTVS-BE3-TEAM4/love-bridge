package com.jolipjo.lovebridge.domain.album.controller;

import com.jolipjo.lovebridge.domain.album.dto.*;
import com.jolipjo.lovebridge.domain.album.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {


    private final AlbumService albumService;
//    private final MessageSource messageSource;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
//        this.messageSource = messageSource;
    }



    // 앨범 화면 불러오기
    @GetMapping
    public String albumListPage(Model model) {

        List<AlbumListResponseDTO> albumListResponseDTOS = albumService.albumListPage();
        System.out.println(albumListResponseDTOS);
        model.addAttribute("albumList", albumListResponseDTOS);



//        List<AlbumListRequestDTO> dtos = new ArrayList<>();
//        AlbumListRequestDTO albumList1 = new AlbumListRequestDTO();
//        albumList1.setDate("123");
//        albumList1.setMemo("123");
//        albumList1.setImage("qqq");
//        model.addAttribute("albumlist1", albumList1);
//        dtos.add(albumList1);
//        dtos.add(albumList1);
//        dtos.add(albumList1);
//        dtos.add(albumList1);
//        model.addAttribute("albumList1", dtos);

        return "html/album/album-list";
    }


    //2. 삭제하기
    @PostMapping("{id}")
    public void albumDelete(@PathVariable int id,AlbumDeleteDTO albumDeleteDTO, Model model) {
        albumService.albumDelete(albumDeleteDTO,id);
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

    public String albumModifyLoad( @PathVariable("id") int id, Model model) {

        AlbumModifyResponseDTO albumModify = albumService.albumModifyLoad(id);
        model.addAttribute("albumModify", albumModify);


        System.out.println("수정 페이지 호출");
        System.out.println(albumModify.getId());

        return "html/album/album-modify";
    }


    //6.수정 값 보내기
    @PostMapping("modify")
    public String albumModifySend(AlbumModifyRequestDTO albumModifyRequestDTO) {

        albumService.albumModifySend(albumModifyRequestDTO);

        return "redirect:/album";
    }

}























