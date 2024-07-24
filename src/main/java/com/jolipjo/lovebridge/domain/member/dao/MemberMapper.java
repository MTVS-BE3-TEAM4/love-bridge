package com.jolipjo.lovebridge.domain.member.dao;

import com.jolipjo.lovebridge.domain.member.dto.AddSecretCodeUserDTO;
import com.jolipjo.lovebridge.domain.member.dto.ChangePasswordRequestDTO;
import com.jolipjo.lovebridge.domain.member.dto.MypageRequestDTO;
import com.jolipjo.lovebridge.domain.member.dto.MypageResponseDTO;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.member.entity.SecretCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    void join(Member member);

    void createSecretCode(SecretCode secretCode);

    SecretCode findSecretByCode(String code);

    void addSecretCodeUser(AddSecretCodeUserDTO dto);

    SecretCode findSecretCodeByMemberId(Long memberId);

    List<Long> findMembersBySecretCode(Long secretCodeId);

    Long findMyPartner(Long memberId);

    Member findByEmail(String username);

    MypageResponseDTO getMypageInfo(Long memberId);

    void UpdateMemberInfo(MypageRequestDTO mypageRequestDTO);

    String getPassword(Long id);

    void changePassword(ChangePasswordRequestDTO dto);

    Member findMyPartnerInfo(Long memberId);

    Member getMemberInfo(Long memberId);

//    void changePassword(ChangePasswordRequestDTO dto);
}
