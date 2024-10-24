package com.ProiectareSoftware.myLifeStyle.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicRequest {
    private String artist;
    private String songName;
    private String genre;
}
