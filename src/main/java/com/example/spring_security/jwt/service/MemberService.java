package com.example.spring_security.jwt.service;

import com.example.spring_security.jwt.dto.JwtToken;

public interface MemberService {
    public JwtToken login(String username, String password);
}
