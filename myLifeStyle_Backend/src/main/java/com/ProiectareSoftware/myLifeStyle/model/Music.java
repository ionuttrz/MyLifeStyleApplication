package com.ProiectareSoftware.myLifeStyle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data     //no need for constructor, getters and setters
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "music")
public class Music {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "emailUser")
    private String emailUser;

    @Column(name = "artist")
    private String artist;

    @Column(name = "songName")
    private String songName;

    @Column(name = "genre")
    private String genre;

}
