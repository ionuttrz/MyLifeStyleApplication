package com.ProiectareSoftware.myLifeStyle.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DietRequest {
    private Float mass;
    private Float height;
    private Integer age;
    private String activity;
}
