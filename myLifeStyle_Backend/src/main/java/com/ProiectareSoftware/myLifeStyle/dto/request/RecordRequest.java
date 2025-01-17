package com.ProiectareSoftware.myLifeStyle.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordRequest {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Float kmRun;

    private Float hoursAtTheGym;

    private Float drinkingWater;

}
