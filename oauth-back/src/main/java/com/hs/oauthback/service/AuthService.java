package com.hs.oauthback.service;

import org.springframework.http.ResponseEntity;

import com.hs.oauthback.dto.request.auth.SignUpRequestDto;
import com.hs.oauthback.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
}
