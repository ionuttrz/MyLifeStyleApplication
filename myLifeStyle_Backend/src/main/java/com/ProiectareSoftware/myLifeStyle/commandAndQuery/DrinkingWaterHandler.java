package com.ProiectareSoftware.myLifeStyle.commandAndQuery;

import com.ProiectareSoftware.myLifeStyle.dto.GetDrinkingWaterQuery;
import com.ProiectareSoftware.myLifeStyle.model.Record;
import com.ProiectareSoftware.myLifeStyle.repository.RecordRepository;
import com.ProiectareSoftware.myLifeStyle.strategy.chartperiod.IStrategy;
import com.ProiectareSoftware.myLifeStyle.strategy.chartperiod.Strategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DrinkingWaterHandler implements RequestHandler<GetDrinkingWaterQuery, List<Float>> {

    @Autowired
    RecordRepository recordRepository;

    @Override
    public List<Float> handle(GetDrinkingWaterQuery getDrinkingWaterQuery) throws IllegalAccessException {
        List<Record> stressMetrics;
        String email = getDrinkingWaterQuery.getAccessToken().getName();
        IStrategy iStrategy = Strategy.getDays(getDrinkingWaterQuery.getDays());
        LocalDate currentDate = LocalDate.now();
        Date startDate = Date.from(currentDate.minusDays(getDrinkingWaterQuery.getDays()).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(currentDate.atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
        stressMetrics = recordRepository.findByDatesInRange(startDate, endDate, email);
        return iStrategy.getListOfDays(stressMetrics, "drinkingWater");
    }
}
