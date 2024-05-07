package com.example.spring_security.jwt.service;

import com.example.spring_security.jwt.dto.JwtToken;

public interface MemberService {
    public JwtToken signIn(String username, String password);
}
