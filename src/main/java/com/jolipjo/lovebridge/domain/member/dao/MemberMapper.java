package com.jolipjo.lovebridge.domain.member.dao;

import com.jolipjo.lovebridge.domain.member.dto.FindEmailResponseDTO;
import com.jolipjo.lovebridge.domain.member.dto.JoinRequestDTO;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    void join(Member member);
}
