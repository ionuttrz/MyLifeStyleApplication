package com.ProiectareSoftware.myLifeStyle.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data     //no need for constructor, getters and setters
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "record")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "emailUser")
    private String emailUser;

    @Column(name = "kmRun")
    private Float kmRun;

    @Column(name = "hoursAtTheGym")
    private Float hoursAtTheGym;

    @Column(name = "drinkingWater")
    private Float drinkingWater;
}
