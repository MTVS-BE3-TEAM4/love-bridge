package com.jolipjo.lovebridge.domain.member.dto;

import com.jolipjo.lovebridge.domain.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomMemberDetail implements UserDetails {
    private final Member member;

    public CustomMemberDetail(Member member) {
        this.member = member;
    }

    /*사용자 권한 반환*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList();

        /*권한을 끄집어 내서 반환함*/
        authorities.add((GrantedAuthority) () -> member.getRole());

        return authorities;
    }

    public Member getMember() {
        return member;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getEmail();
    }

    /*계정이 만료되지 않았는가?*/
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /*계정이 잠겨있지는 않은가?*/
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /*비밀번호가 만료되 있지는 않은가?*/
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /*계정이 활성화 되 있는가?*/
    @Override
    public boolean isEnabled() {
        return true;
    }
}
