package com.ProiectareSoftware.myLifeStyle.repository;

import com.ProiectareSoftware.myLifeStyle.model.Music;
import com.ProiectareSoftware.myLifeStyle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {
    List<Music> findAllByEmailUser(String email);
    Optional<Music> findAllByEmailUserAndArtist(String email, String artist);
    Optional<Music> findAllByEmailUserAndGenre(String email, String genre);
    Boolean existsByEmailUserAndArtistAndSongName(String emailUser, String artist, String songName);
}
