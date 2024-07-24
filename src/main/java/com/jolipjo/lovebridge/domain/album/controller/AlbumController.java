package com.jolipjo.lovebridge.domain.album.controller;

import com.jolipjo.lovebridge.common.FileUploader;
import com.jolipjo.lovebridge.domain.album.dto.*;
import com.jolipjo.lovebridge.domain.album.service.AlbumService;
import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.dto.FindPasswordRequestDTO;
import com.jolipjo.lovebridge.domain.member.dto.FindPasswordResponseDTO;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {


    private final AlbumService albumService;
//    private final MessageSource messageSource;
//    private final FileUploader fileUploader;





    public AlbumController(AlbumService albumService, FileUploader fileUploader) {
        this.albumService = albumService;
//        this.fileUploader = fileUploader;
    }

    // 앨범 화면 불러오기
    @GetMapping
    public String albumListPage(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                                Model model) {

        Member member = customMemberDetail.getMember();

        List<AlbumListResponseDTO> albumListResponseDTOS = albumService.albumListPage(member.getId());
        System.out.println(albumListResponseDTOS);
        System.out.println("member : " + member.getId());
        model.addAttribute("albumList", albumListResponseDTOS);




//        로그인 한놈
        member.getId();





        return "html/album/album-list";
    }


  //삭제하기
    @PostMapping("{id}")
    public ResponseEntity<Void> albumDelete(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                                            @PathVariable int id, AlbumDeleteDTO albumDeleteDTO) {

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
    public String albumWrite(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                             AlbumWriteRequestDTO albumWriteRequestDTO, Model model) {


        Member member = customMemberDetail.getMember();

        albumWriteRequestDTO.setMemberId(member.getId());

        albumService.albumWrite(albumWriteRequestDTO);

//        albumService.albumWrite(albumWriteRequestDTO);

        System.out.println("dd");
        System.out.println(albumWriteRequestDTO);


        return "redirect:/album";
    }



    //5.수정 값 가져오기
    @GetMapping("modify/{id}")
    public String albumModifyLoad(@PathVariable Long id, Model model) {

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























