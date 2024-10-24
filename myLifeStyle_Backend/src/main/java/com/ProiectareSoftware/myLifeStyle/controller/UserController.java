package com.ProiectareSoftware.myLifeStyle.controller;

import com.ProiectareSoftware.myLifeStyle.dto.request.LoginRequest;
import com.ProiectareSoftware.myLifeStyle.dto.request.RegisterRequest;
import com.ProiectareSoftware.myLifeStyle.dto.response.AuthenticationResponse;
import com.ProiectareSoftware.myLifeStyle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        return userService.register(registerRequest);
    }
}
