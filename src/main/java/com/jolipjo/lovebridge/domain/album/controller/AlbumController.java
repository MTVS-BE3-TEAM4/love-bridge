package com.jolipjo.lovebridge.domain.album.controller;

import com.jolipjo.lovebridge.common.FileUploader;
import com.jolipjo.lovebridge.domain.album.dto.*;
import com.jolipjo.lovebridge.domain.album.service.AlbumService;
import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.member.entity.SecretCode;
import com.jolipjo.lovebridge.domain.member.service.MemberService;
import com.jolipjo.lovebridge.domain.paginaition.dto.PaginationDTO;
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
    private final FileUploader fileUploader;
    private final MemberService memberService;

    public AlbumController(AlbumService albumService, FileUploader fileUploader,MemberService memberService) {
        this.albumService = albumService;
        this.fileUploader = fileUploader;
        this.memberService = memberService;
    }

    // 앨범 화면 불러오기
    @GetMapping
    public String albumListPage(@AuthenticationPrincipal CustomMemberDetail customMemberDetail,
                                @RequestParam(defaultValue = "1", name = "page") int page,
                                @RequestParam(defaultValue = "8", name = "size") int size,
                                RedirectAttributes redirectAttributes,
                                Model model) {


        Member member = customMemberDetail.getMember();
        SecretCode secretCode = memberService.getSecretCode(member.getId());

        if (secretCode == null || secretCode.getM_member_id() == null || secretCode.getF_member_id() == null) {
            redirectAttributes.addFlashAttribute("message", "커플이 아닙니다. album 리스트를 볼 수 없습니다.");
            return "redirect:/";
        }

        Long m = secretCode.getF_member_id();
        Long f = secretCode.getM_member_id();

        List<AlbumListResponseDTO> albumListResponseDTOS1 = albumService.albumListPage(m);
        List<AlbumListResponseDTO> albumListResponseDTOS2 = albumService.albumListPage(f);
        albumListResponseDTOS1.addAll(albumListResponseDTOS2);

        PaginationDTO<AlbumListResponseDTO> paginationDTO = new PaginationDTO<>(page, size, albumListResponseDTOS1, albumListResponseDTOS1.size());
        model.addAttribute("paginationDTO", paginationDTO);


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























