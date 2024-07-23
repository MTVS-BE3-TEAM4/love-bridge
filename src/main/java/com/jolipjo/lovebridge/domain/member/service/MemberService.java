package com.jolipjo.lovebridge.domain.member.service;


import com.jolipjo.lovebridge.domain.member.dao.MemberMapper;
import com.jolipjo.lovebridge.domain.member.dto.*;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.member.entity.SecretCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public MemberService(MemberMapper memberMapper, BCryptPasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    /*회원가입*/
    public void join(JoinRequestDTO joinRequestDTO) {

        /*회원 엔티티 생성
        *
        * 엔티티 생성 이유:
        * DTO랑 DB에 있는 데이터가 달라서 DB 테이블과 1:1 매칭된 객체를 만들어서 쓴거ㅇㅇ(걍 나 편하려고 만든거ㅇㅇ)
        * */
        Member member = new Member();

        /*DTO -> Entity 변환*/
        member.setEmail(joinRequestDTO.getEmail());
        member.setGender(joinRequestDTO.getGender());
        member.setBirth(joinRequestDTO.getBirth());
        member.setNickname(joinRequestDTO.getNickname());
        member.setPassword(passwordEncoder.encode(joinRequestDTO.getPassword()) );
        member.setMarketingAgree(joinRequestDTO.getMarketingAgree());
        member.setRole("ROLE_USER");

        /*DB에 회원정보 저장*/
        memberMapper.join(member);
    }

    /*사용자 시크릿코드 생성*/
    public SecretCode createSecretCode(Long memberId){
        /*시크릿 코드 생성*/
        SecretCode secretCode = generateSecretCode();
        secretCode.setCount(1);
        memberMapper.createSecretCode(secretCode);

        /*DB에 저장된 시크릿코드를 가져옴(시크릿코드 ID 가져옴)*/
        secretCode = memberMapper.findSecretByCode(secretCode.getCode());

        /*사용자와 시크릿코드 연관관계 추가*/
        AddSecretCodeUserDTO dto = new AddSecretCodeUserDTO();
        dto.setMemberId(memberId);
        dto.setSecretCodeId(secretCode.getId());
        memberMapper.addSecretCodeUser(dto);

        return secretCode;
    }

    /*사용자의 시크릿코드 추출*/
    public SecretCode getSecretCode(Long memberId){

        return memberMapper.findSecretCodeByMemberId(memberId);
    }

    public Member getByEmail(String email){
        return memberMapper.findByEmail(email);
    }


    /*시크릿 코드로 상대방 초대
    * host:     시크릿코드를 갖고 있는 사람
    * guest:    시크릿코드로 초대를 받는 상대방*/
    public void inviteSecretCode(Long host, Long guest){

        AddSecretCodeUserDTO dto = new AddSecretCodeUserDTO();
        dto.setMemberId(guest);
        dto.setSecretCodeId(memberMapper
                .findSecretCodeByMemberId(host)
                .getId()
        );

        memberMapper.addSecretCodeUser(dto);
    }

    /*해당 시크릿코드와 연결된 사용자들 검색*/
    public List<Long> getMembersBySecretCode(Long secretCodeId){
        return memberMapper.findMembersBySecretCode(secretCodeId);
    }

    /*나와 연결된 시크릿코드를 가진 사용자 id 검색*/
    public Long getPartner(Long memberId){
        return memberMapper.findMyPartner(memberId);
    }

    public Member getPartnerInfo(Long memberId){
        return memberMapper.findMyPartnerInfo(memberId);
    }

    public String getMemberById(Long memberId){
        return memberMapper.getMemberInfo(memberId);
    }

    public MypageResponseDTO getMypageInfo(Long memberId){
        return memberMapper.getMypageInfo(memberId);
    }


    /*시크릿 코드 생성 헬퍼 메소드(혁진쨩이 내부적으로만 사용하는 메소드)*/
    private SecretCode generateSecretCode(){

        /*시크릿 코드 생성*/
        SecretCode secretCode = new SecretCode();
        String code = UUID.randomUUID().toString().split("-")[0];

        /*엔티티에 값 입력*/
        secretCode.setCode(code);
        secretCode.setCount(0);

        return secretCode;
    }

    public void updateMemberInfo(MypageRequestDTO mypageRequestDTO) {
        memberMapper.UpdateMemberInfo(mypageRequestDTO);
    }

    public Boolean changePassword(ChangePasswordRequestDTO dto) {
        String password = memberMapper.getPassword(dto.getId());

        if(passwordEncoder.matches(dto.getOldPassword(), password)){
            System.out.println("비번 일치함!");
            String encodePassword = passwordEncoder.encode(dto.getNewPassword());

            dto.setNewPassword(encodePassword);
            memberMapper.changePassword(dto);
            return true;
        } else {
            System.out.println("비번 틀림ㅅㄱ");
        } 

        return false;
    }

}
