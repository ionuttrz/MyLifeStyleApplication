package com.ProiectareSoftware.myLifeStyle.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicResponse {
    private String artist;
    private String songName;
    private String genre;
}

