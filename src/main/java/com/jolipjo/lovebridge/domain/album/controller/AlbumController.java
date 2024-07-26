package com.jolipjo.lovebridge.domain.album.controller;

import com.jolipjo.lovebridge.common.FileUploader;
import com.jolipjo.lovebridge.domain.album.dto.*;
import com.jolipjo.lovebridge.domain.album.service.AlbumService;
import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.dto.FindPasswordRequestDTO;
import com.jolipjo.lovebridge.domain.member.dto.FindPasswordResponseDTO;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.paginaition.dao.PaginationMapper;
import com.jolipjo.lovebridge.domain.paginaition.dto.PaginationDTO;
import com.jolipjo.lovebridge.domain.timecapsule.dto.Timecapsule;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {


    private final AlbumService albumService;
    private final FileUploader fileUploader;
//    private final MessageSource messageSource;
//    private final FileUploader fileUploader;





    public AlbumController(AlbumService albumService, FileUploader fileUploader) {
        this.albumService = albumService;
//        this.fileUploader = fileUploader;
        this.fileUploader = fileUploader;
    }

    // 앨범 화면 불러오기
    @GetMapping
    public String albumListPage(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                                @RequestParam(defaultValue = "1", name = "page") int page,
                                @RequestParam(defaultValue = "8", name = "size") int size,
                                Model model) {

        Member member = customMemberDetail.getMember();
        long memberId = member.getId();

        List<AlbumListResponseDTO> albumListResponseDTOS = albumService.albumListPage(member.getId());
        //model.addAttribute("albumList", albumListResponseDTOS);


        PaginationDTO<AlbumListResponseDTO> paginationDTO = new PaginationDTO<>(page, size, albumListResponseDTOS, albumListResponseDTOS.size());
        model.addAttribute("paginationDTO", paginationDTO);

//        int totalItems = albumService.getTotatlItem(memberId , page, size);
//        int totalPages = (int) Math.ceil((double) totalItems/size);
//
//        //페이지와 사이즈가 1이상의 값으로 설정되도록 보장
//        if (page < 1) page = 1;
//        if (size < 1) size = 8;
//
//        // 총 항목수가 0인 경우를 처리
//        if (totalItems == 0) {
//            model.addAttribute("albumList", Collections.emptyList());
//            model.addAttribute("currentPage", 1);
//            model.addAttribute("pageSize", size);
//            model.addAttribute("totalPages", 1);
//            model.addAttribute("startPage", 1);
//            model.addAttribute("endPage", 1);
//            return "html/album/album-list";
//        }
//
//        if (page > totalPages) page = totalPages;
//        int startPage = Math.max(1, page - 2);
//        int endPage = Math.min(totalPages, page + 2);
//
//        model.addAttribute("albumList", albumListResponseDTOS);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("pageSize", size);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("startPage", startPage);
//        model.addAttribute("endPage", endPage);

        return "html/album/album-list";
    }


  //삭제하기
    @PostMapping("{id}")
    public ResponseEntity<Void> albumDelete(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                                            @PathVariable(name = "id") int id, AlbumDeleteDTO albumDeleteDTO) {

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
                             @RequestParam(name = "file") MultipartFile file,
                             AlbumWriteRequestDTO albumWriteRequestDTO, Model model) {

        //로그인 아이디 넘기기
        Member member = customMemberDetail.getMember();
        albumWriteRequestDTO.setMemberId(member.getId());

        //파일럽로더 파일 불러오기
        String url = fileUploader.saveFile(file);
        System.out.println("url = " + url);
        //url을 DTO의 이미지에 넣기
        albumWriteRequestDTO.setImage(url);
        //보여주기
        model.addAttribute("img", url);
        //서비스 단으로 보내주기
        albumService.albumWrite(albumWriteRequestDTO);



        return "redirect:/album";
    }



    //5.수정 값 가져오기
    @GetMapping("modify/{id}")
    public String albumModifyLoad(@PathVariable(name = "id") Long id, Model model) {

        AlbumModifyRequestDTO albumModify = albumService.albumModifyLoad(id);
        model.addAttribute("albumModify", albumModify);



        System.out.println("수정 페이지 호출");
        System.out.println(albumModify);


        return "html/album/album-modify";
    }



    //6.수정 값 보내기
    @PostMapping("modify/{id}")
    public String albumModifySend(@PathVariable Long id,
                                  @RequestParam(name = "file") MultipartFile file,
                                  AlbumModifyResponseDTO albumModifyResponseDTO) {

        albumModifyResponseDTO.setId(id);

        String url = fileUploader.saveFile(file);
        System.out.println("url = " + url);
        albumModifyResponseDTO.setImage(url);


        albumService.albumModifySend(albumModifyResponseDTO);


        return "redirect:/album";
    }

}























