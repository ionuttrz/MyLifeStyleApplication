package com.ProiectareSoftware.myLifeStyle.controller;

import com.ProiectareSoftware.myLifeStyle.dto.request.DietRequest;
import com.ProiectareSoftware.myLifeStyle.dto.request.MusicRequest;
import com.ProiectareSoftware.myLifeStyle.service.DietService;
import com.ProiectareSoftware.myLifeStyle.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diet")
@CrossOrigin(origins = "*")
public class DietController {
    @Autowired
    DietService dietService;
    @PostMapping("/calculateCalories")
    public ResponseEntity<?> calculateCalories(Authentication accessToken, @RequestBody DietRequest dietRequest) throws IllegalAccessException {
        return dietService.calculateCalories(accessToken, dietRequest);
    }
}
