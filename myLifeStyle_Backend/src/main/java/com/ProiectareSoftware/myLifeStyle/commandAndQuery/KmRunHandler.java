package com.ProiectareSoftware.myLifeStyle.commandAndQuery;

import com.ProiectareSoftware.myLifeStyle.dto.GetKmRunQuery;
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

public class KmRunHandler implements RequestHandler<GetKmRunQuery, List<Float>> {
    @Autowired
    RecordRepository recordRepository;

    public List<Float> handle(GetKmRunQuery getKmRunQuery) throws IllegalAccessException {
        List<Record> durationMetrics;
        String email = getKmRunQuery.getAccessToken().getName();
        IStrategy iStrategy = Strategy.getDays(getKmRunQuery.getDays());
        LocalDate currentDate = LocalDate.now();
        Date startDate = Date.from(currentDate.minusDays(getKmRunQuery.getDays()).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(currentDate.atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
        durationMetrics = recordRepository.findByDatesInRange(startDate, endDate, email);
        return iStrategy.getListOfDays(durationMetrics, "km");
    }
}
