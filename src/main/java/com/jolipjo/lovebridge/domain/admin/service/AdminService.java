package com.jolipjo.lovebridge.domain.admin.service;

import com.jolipjo.lovebridge.domain.admin.dao.AdminMapper;
import com.jolipjo.lovebridge.domain.admin.dto.MemberInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminMapper adminMapper;

    public AdminService(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

//    public Boolean updateMemberInfo(MemberInfoDTO memberInfoDTO) {
//
//    }

    public List<MemberInfoDTO> getAllMembers(){
        return adminMapper.findAllMembers();
    }
}
