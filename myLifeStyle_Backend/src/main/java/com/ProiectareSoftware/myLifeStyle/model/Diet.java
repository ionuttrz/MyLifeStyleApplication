package com.ProiectareSoftware.myLifeStyle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data     //no need for constructor, getters and setters
@NoArgsConstructor
@AllArgsConstructor
public class Diet {
    private Float mass;
    private Float height;
    private Integer age;
    private String activity;
}
