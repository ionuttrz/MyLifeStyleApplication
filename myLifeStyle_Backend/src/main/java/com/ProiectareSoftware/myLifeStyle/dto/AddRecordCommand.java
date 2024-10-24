package com.ProiectareSoftware.myLifeStyle.dto;

import com.ProiectareSoftware.myLifeStyle.commandAndQuery.IRequest;
import com.ProiectareSoftware.myLifeStyle.model.Record;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRecordCommand implements IRequest<Record> {
    private Authentication accessToken;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Float kmRun;

    private Float hoursAtTheGym;

    private Float drinkingWater;

}
