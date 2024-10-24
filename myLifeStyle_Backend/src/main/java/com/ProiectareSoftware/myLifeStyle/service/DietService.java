package com.ProiectareSoftware.myLifeStyle.service;

import com.ProiectareSoftware.myLifeStyle.dto.request.DietRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface DietService {
    ResponseEntity<?> calculateCalories(Authentication accessToken, DietRequest dietRequest) throws IllegalAccessException;
}
