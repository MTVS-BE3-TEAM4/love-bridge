package com.jolipjo.lovebridge.domain.member.service;

import com.jolipjo.lovebridge.domain.member.dao.MemberMapper;
import com.jolipjo.lovebridge.domain.member.dto.CustomMemberDetail;
import com.jolipjo.lovebridge.domain.member.entity.Member;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomMemberService implements UserDetailsService {

    private final MemberMapper memberMapper;

    public CustomMemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username = " + username);
        Member member = memberMapper.findByEmail(username);
        System.out.println("member = " + member);
        if(member != null) {
            return new CustomMemberDetail(member);
        }
        return null;
    }
}
