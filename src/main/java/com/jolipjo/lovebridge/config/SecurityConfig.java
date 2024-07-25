package com.jolipjo.lovebridge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsService userDetailsService;

    @Value("${security.rememberMe.tokenValiditySeconds}")
    private int rememberMeMaxAgeSeconds;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /*시큐리티 설정*/
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*url 경로 권한*/
        http
                .authorizeHttpRequests( (auth) -> auth
                                .requestMatchers("css/**", "js/**", "images/**").permitAll()// 템플릿 경로
                                .requestMatchers("/include/header").permitAll()
                                .requestMatchers("/").permitAll()// 메인페이지 누구나 접근 가능
                                .requestMatchers("/member/join").permitAll()// 회원가입 페이지는 누구나 접근 가능
                                .requestMatchers("/member/joinProc").permitAll()
                                .requestMatchers("/admin/**").hasRole("ADMIN")// 관리자 페이지는 관리자만 접근
                                .requestMatchers("/board/notice/write").hasRole("ADMIN")// 공지사항 작성
                                .requestMatchers("/board/notice/edit/**").hasRole("ADMIN")// 공지사항 수정
//                        .anyRequest().permitAll()
                                .anyRequest().authenticated()// 그 외에는 로그인 해야 함
                );

        /*로그인 페이지*/
        http
                .formLogin( (form) -> form
                        .loginPage("/member/login")// 로그인 페이지 url
                        .usernameParameter("email")// 이메일로 로그인함
                        .passwordParameter("password")
                        .loginProcessingUrl("/member/loginProc")// 로그인 처리 경로
                        .permitAll()
                );

        /*자동 로그인*/
        http
                .rememberMe((remember) -> remember
                        .rememberMeParameter("rememberMe")
                        .tokenValiditySeconds(rememberMeMaxAgeSeconds)
                        .alwaysRemember(false)
                        .userDetailsService(userDetailsService)
                );

        /*로그아웃 페이지*/
        http
                .logout( (logout) ->
                        logout.logoutUrl("/member/logout")
                        .logoutSuccessUrl("/")
                );

        /*CSRF 끔(개발용)*/
        http
                .csrf(AbstractHttpConfigurer::disable);

        /*세션 설정*/
        http
                .sessionManagement((session) -> session
                        .sessionFixation().changeSessionId()// 세션 고정 공격 방어
                        .maximumSessions(3)// 동시 로그인 기기는 3대가 최대
                        .maxSessionsPreventsLogin(false)// 3대 넘게 로그인하면 하나 강제로 로그아웃 시킴
                );

        return http.build();
    }

    /*비밀번호 암호화*/
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
