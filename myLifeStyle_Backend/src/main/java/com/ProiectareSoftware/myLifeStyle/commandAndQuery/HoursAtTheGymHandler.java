package com.ProiectareSoftware.myLifeStyle.commandAndQuery;

import com.ProiectareSoftware.myLifeStyle.dto.GetHoursAtTheGymQuery;
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
public class HoursAtTheGymHandler implements RequestHandler<GetHoursAtTheGymQuery, List<Float>> {
    @Autowired
    RecordRepository recordRepository;

    public List<Float> handle(GetHoursAtTheGymQuery getHoursAtTheGymQuery) throws IllegalAccessException {
        List<Record> energyMetrics;
        String email = getHoursAtTheGymQuery.getAccessToken().getName();
        IStrategy iStrategy = Strategy.getDays(getHoursAtTheGymQuery.getDays());
        LocalDate currentDate = LocalDate.now();
        Date startDate = Date.from(currentDate.minusDays(getHoursAtTheGymQuery.getDays()).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(currentDate.atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
        energyMetrics = recordRepository.findByDatesInRange(startDate, endDate, email);
        return iStrategy.getListOfDays(energyMetrics, "hoursAtGym");
    }
}
