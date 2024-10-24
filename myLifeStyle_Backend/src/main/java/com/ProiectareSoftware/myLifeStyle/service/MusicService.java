package com.ProiectareSoftware.myLifeStyle.service;

import com.ProiectareSoftware.myLifeStyle.dto.request.MusicRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface MusicService {
    ResponseEntity<?> addMusic(Authentication authentication, MusicRequest musicRequest);
    ResponseEntity<?> showAllMusic(Authentication authentication);
    ResponseEntity<?> listByGenre(Authentication authentication, String genre);
    ResponseEntity<?> searchByArtist(Authentication authentication, String artist);
}
