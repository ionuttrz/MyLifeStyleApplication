package com.ProiectareSoftware.myLifeStyle.dto;

import com.ProiectareSoftware.myLifeStyle.commandAndQuery.IRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetHoursAtTheGymQuery implements IRequest<List<Float>> {
    private Authentication accessToken;
    private int days;
}
