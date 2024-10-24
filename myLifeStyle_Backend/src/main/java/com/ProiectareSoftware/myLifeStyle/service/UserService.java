package com.ProiectareSoftware.myLifeStyle.service;

import com.ProiectareSoftware.myLifeStyle.dto.request.RegisterRequest;
import com.ProiectareSoftware.myLifeStyle.dto.response.AuthenticationResponse;
import com.ProiectareSoftware.myLifeStyle.dto.request.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<AuthenticationResponse> login(LoginRequest loginRequest);
    ResponseEntity<?> register(RegisterRequest registerRequest);
}
