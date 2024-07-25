package com.jolipjo.lovebridge.domain.board.controller;

import com.jolipjo.lovebridge.domain.board.dto.*;
import com.jolipjo.lovebridge.domain.board.service.BoardService;
import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/board/") // 컨트롤러의 기본 URL 경로를 설정
public class BoardController { // 클래스의 선언부

    private final BoardService boardService; // BoardService 타입의 서비스를 주입받아 사용. final은 초기화 이후에 변경될 수 없음을 의미
    public BoardController(BoardService boardService) { // 생성자에서 BoardService 객체를 주입. 이 생성자를 통해 의존성 주입을 수행
        this.boardService = boardService;
    }

    //공지사항 목록 갖고오기-->완료
    @GetMapping("notice") // /board/notice url에 대한 GET 요청을 처리
    public String boardNotice(Model model) { // 이 메서드는 게시판 목록을 조회하여 뷰에 전달

        BoardNoticeDTO boardNoticeDTO = new BoardNoticeDTO(); // new BoardNoticeDTO 클래스의 기본 생성자를 호출하여 새로운 객체를 생성
        List<BoardNoticeDTO> boardList = boardService.getBoardList(boardNoticeDTO); // boardservice를 사용하여 게시판 목록을 가져온다.
        model.addAttribute("boardList", boardList); // 가져온 게시판 목록을 모델에 추가하여 뷰에 전달
        return "html/board/notice/board-notice"; // board-notice라는 뷰 이름을 반환. 스프링은 이 이름을 사용하여 적절한 뷰를 렌더링

    }

    //공지사항 상세 글 조회-->완료
    @GetMapping("notice/{id}") // url에 대한 get 요청을 처리
    public String boardNoticeView(@PathVariable("id") int id, Model model) { // 이 메서드는 특정 게시글의 상세 정보를 조회하여 뷰에 전달

        BoardViewDTO boardViewDTO = boardService.getBoardView(id);
        model.addAttribute("boardViewDTO", boardViewDTO);
        return "html/board/notice/board-notice-view"; // 스프링은 이 이름을 사용하여 적절한 뷰를 렌더링
    }

    //공지사항 글 수정시 기존 글 갖고오기-->완료
    @GetMapping("notice/edit/{id}")
    public String boardNoticeEditGet(@PathVariable int id, Model model) {

        BoardEditDTO boardEditDTO = boardService.getBoardEdit(id);
        model.addAttribute("boardEditDTO", boardEditDTO);
        return "html/board/notice/board-notice-edit";
    }

    //공지사항 글 수정하기-->완료
    @PostMapping("notice/edit/{id}")
    public String boardNoticeEditPost(@PathVariable int id, BoardEditDTO boardEditDTO) {

        boardEditDTO.setId(id);
        boardService.boardModify(boardEditDTO);
        return "redirect:/board/notice";
    }
    //공지사항 글 삭제하기 테스트-->진행 중
    @PostMapping("notice/{id}/delete")
    public String boardNoticeDelete(@PathVariable int id,
                                    @AuthenticationPrincipal CustomMemberDetail customMemberdeleteDetail,
                                    Model model) {
        Member member = customMemberdeleteDetail.getMember();
        BoardViewDTO boardViewDTO = boardService.getBoardView(id);

        if(boardViewDTO.getMemberId() == member.getId()) {
            BoardDeleteDTO boardDeleteDTO = new BoardDeleteDTO();
            boardDeleteDTO.setId(id);
            boardService.boardDelete(boardDeleteDTO, id);
            System.out.println("게시글 삭제 완료");
            return "redirect:/board/notice";
        } else {
            System.out.println("로그인하세요.");
            model.addAttribute("errorMessage", "로그인하세요.");
            return "redirect:/board/notice";
        }
    }

    //공지사항 작성 창 불러오기-->완료
    @GetMapping("notice/write")
    public String boardNoticeWrite(Model model) {

        BoardWriteDTO boardWriteDTO = new BoardWriteDTO();
        model.addAttribute("message", boardWriteDTO);
        return "html/board/notice/board-notice-write";
    }
    //공지사항 작성하기-->완료
    @PostMapping("notice/write")
    public String boardNoticeWrite(BoardWriteDTO newPost,
                                   @AuthenticationPrincipal CustomMemberDetail customMemberwriteDetail) {

        Member member = customMemberwriteDetail.getMember();
        newPost.setMemberId(member.getId());
        newPost.setDate(LocalDateTime.now());
        boardService.writeNewPost(newPost);
        return "redirect:/board/notice";

//        newPost.setMemberId(1);
//        System.out.println("newPost = " + newPost);
//        customMemberwriteDetail.getMember().getId();
//        System.out.println("아이디 : " + customMemberwriteDetail.getMember().getId());

    }
}

//공지사항 글 삭제하기-->진행 중
//    @PostMapping("notice/{id}")
//    public String boardNoticeDelete(@PathVariable int id, BoardDeleteDTO boardDeleteDTO){
//
//        boardDeleteDTO.setId(id);
//        boardService.boardDelete(boardDeleteDTO, id);
//        System.out.println("Delete 실행");
//
//        return "redirect:/board/notice";
//    }
