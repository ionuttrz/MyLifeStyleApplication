package com.ProiectareSoftware.myLifeStyle.dto;

import com.ProiectareSoftware.myLifeStyle.model.Record;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordDTO {

    private Integer id;

    private String emailUser;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Float kmRun;

    private Float hoursAtTheGym;

    private Float drinkingWater;

    public RecordDTO(Record record) {
        this.id = record.getId();
        this.emailUser = record.getEmailUser();
        this.date = record.getDate();
        this.kmRun = record.getKmRun();
        this.hoursAtTheGym = record.getHoursAtTheGym();
        this.drinkingWater = record.getDrinkingWater();
    }
}
