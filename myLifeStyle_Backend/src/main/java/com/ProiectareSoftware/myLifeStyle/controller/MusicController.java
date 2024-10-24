package com.ProiectareSoftware.myLifeStyle.controller;

import com.ProiectareSoftware.myLifeStyle.dto.request.MusicRequest;
import com.ProiectareSoftware.myLifeStyle.dto.request.RegisterRequest;
import com.ProiectareSoftware.myLifeStyle.service.MusicService;
import com.ProiectareSoftware.myLifeStyle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music")
@CrossOrigin(origins = "*")
public class MusicController {
    @Autowired
    MusicService musicService;
    @PostMapping("/addMusic")
    public ResponseEntity<?> addNewMusic(Authentication accessToken, @RequestBody MusicRequest musicRequest) {
        return musicService.addMusic(accessToken, musicRequest);
    }

    @GetMapping("/showallmusic")
    public ResponseEntity<?> showAllMusic(Authentication accessToken) {
        return musicService.showAllMusic(accessToken);
    }

    @GetMapping("/listbygenre")
    public ResponseEntity<?> listByGenre(Authentication accessToken,@RequestParam String genre) {
        return musicService.listByGenre(accessToken, genre);
    }

    @GetMapping("/searchbyartist")
    public ResponseEntity<?> searchByArtist(Authentication accessToken,@RequestParam String artist) {
        return musicService.searchByArtist(accessToken, artist);
    }
}
