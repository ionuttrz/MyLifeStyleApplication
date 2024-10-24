package com.ProiectareSoftware.myLifeStyle.service;

import com.ProiectareSoftware.myLifeStyle.dto.request.MusicRequest;
import com.ProiectareSoftware.myLifeStyle.dto.response.MusicResponse;
import com.ProiectareSoftware.myLifeStyle.model.Music;
import com.ProiectareSoftware.myLifeStyle.repository.MusicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    MusicRepository musicRepository;

    @Override
    public ResponseEntity<?> addMusic(Authentication authentication, MusicRequest musicRequest) {
        String email = authentication.getName();
        String artist = musicRequest.getArtist();
        String songName = musicRequest.getSongName();
        if (musicRepository.existsByEmailUserAndArtistAndSongName(email, artist, songName)) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: This song sung by the same artist already exists assigned to the user!");
        }
        Music music = new Music();
        music.setEmailUser(email);
        music.setArtist(artist);
        music.setSongName(songName);
        music.setGenre(musicRequest.getGenre());

        music = musicRepository.save(music);

        return ResponseEntity.ok(music);
    }
    @Override
    public ResponseEntity<?> showAllMusic(Authentication authentication){
        String email = authentication.getName();
        List<Music> list = musicRepository.findAllByEmailUser(email);
        System.out.println("Lista cu melodii: "+ list);
        List<MusicResponse> musicResponses = new ArrayList<MusicResponse>();
        for(Music m: list){
            MusicResponse musicResponse = new MusicResponse();
            musicResponse.setArtist(m.getArtist());
            musicResponse.setSongName(m.getSongName());
            musicResponse.setGenre(m.getGenre());
            musicResponses.add(musicResponse);
        }
        return ResponseEntity.ok(musicResponses);
    }

    @Override
    public ResponseEntity<?> listByGenre(Authentication authentication, String genre) {
        String email = authentication.getName();
        List<Music> list = musicRepository.findAllByEmailUser(email);
        System.out.println("Lista cu melodii: "+ list);
        List<MusicResponse> musicResponses = new ArrayList<MusicResponse>();
        for(Music m: list){
            if(m.getGenre().equals(genre)) {
                MusicResponse musicResponse = new MusicResponse();
                musicResponse.setArtist(m.getArtist());
                musicResponse.setSongName(m.getSongName());
                musicResponse.setGenre(m.getGenre());
                musicResponses.add(musicResponse);
            }
        }
        return ResponseEntity.ok(musicResponses);
    }

    @Override
    public ResponseEntity<?> searchByArtist(Authentication authentication, String artist) {
        String email = authentication.getName();
        List<Music> list = musicRepository.findAllByEmailUser(email);
        System.out.println("Lista cu melodii: "+ list);
        List<MusicResponse> musicResponses = new ArrayList<MusicResponse>();
        for(Music m: list){
            if(m.getArtist().equals(artist)) {
                MusicResponse musicResponse = new MusicResponse();
                musicResponse.setArtist(m.getArtist());
                musicResponse.setSongName(m.getSongName());
                musicResponse.setGenre(m.getGenre());
                musicResponses.add(musicResponse);
            }
        }
        return ResponseEntity.ok(musicResponses);
    }
}
