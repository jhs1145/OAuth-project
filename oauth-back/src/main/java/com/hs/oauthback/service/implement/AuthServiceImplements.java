
package com.hs.oauthback.service.implement;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hs.oauthback.dto.request.auth.SignUpRequestDto;
import com.hs.oauthback.dto.response.ResponseDto;
import com.hs.oauthback.dto.response.auth.SignUpResponseDto;
import com.hs.oauthback.entity.UserEntity;
// import com.hs.oauthback.provider.JwtProvider;
import com.hs.oauthback.repository.UserRepository;
import com.hs.oauthback.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplements implements AuthService{
    
    private final UserRepository userRepository;
    // private final JwtProvider jwtProvider;
    
    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        String id = dto.getId();
        // String profileImage = dto.getProfileImage();

        try{
            boolean hasId = userRepository.existsById(id);
            if(hasId) return SignUpResponseDto.existedEmail();

            UserEntity userEntity = new UserEntity(dto);

            userRepository.save(userEntity);

        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        
        return SignUpResponseDto.success();
    }
    
}
