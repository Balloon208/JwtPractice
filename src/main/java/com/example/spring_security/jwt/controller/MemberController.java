package com.example.spring_security.jwt.controller;

import com.example.spring_security.jwt.controller.dto.SigninDto;
import com.example.spring_security.jwt.dto.JwtToken;
import com.example.spring_security.jwt.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public JwtToken SignIn(@RequestBody SigninDto signinDto){
        String username = signinDto.getUsername();
        String password = signinDto.getPassword();
        JwtToken jwtToken = memberService.login(username,password);

        log.info("request username = {}, password = {}", username, password);
        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
        return jwtToken;
    }

    @PostMapping("/test")
    public String test() {
        return "success";
    }
}
