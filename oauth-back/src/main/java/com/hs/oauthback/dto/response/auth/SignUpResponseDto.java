package com.hs.oauthback.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hs.oauthback.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpResponseDto extends ResponseDto {
    private SignUpResponseDto(String code, String message){
        super(code, message);
    }
    public static ResponseEntity<ResponseDto> success() {
    SignUpResponseDto result = new SignUpResponseDto("SU", "Success");
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  // 존재하는 이메일 에러 처리
  public static ResponseEntity<ResponseDto> existedEmail() {
    SignUpResponseDto result = new SignUpResponseDto("EI", "Existed ID");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
}
