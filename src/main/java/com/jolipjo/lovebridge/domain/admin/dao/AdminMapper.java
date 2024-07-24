package com.jolipjo.lovebridge.domain.admin.dao;

import com.jolipjo.lovebridge.domain.admin.dto.MemberInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<MemberInfoDTO> findAllMembers();
}
