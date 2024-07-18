package com.jolipjo.lovebridge.domain.member.service;


import com.jolipjo.lovebridge.domain.member.dao.MemberMapper;
import com.jolipjo.lovebridge.domain.member.dto.JoinRequestDTO;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public MemberService(MemberMapper memberMapper, BCryptPasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

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
        member.setRole("ROLE_USER");

        /*DB에 회원정보 저장*/
        memberMapper.join(member);
    }

    public String createSecretCode(){
        /*시크릿 코드 생성*/
        UUID uuid = UUID.randomUUID();
        return uuid.toString().split("-")[0];
    }
}
