package com.ProiectareSoftware.myLifeStyle.commandAndQuery;

import com.ProiectareSoftware.myLifeStyle.dto.AddRecordCommand;
import com.ProiectareSoftware.myLifeStyle.dto.GetKmRunQuery;
import com.ProiectareSoftware.myLifeStyle.dto.GetHoursAtTheGymQuery;
import com.ProiectareSoftware.myLifeStyle.dto.GetDrinkingWaterQuery;
import com.ProiectareSoftware.myLifeStyle.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MediatorConfig {

    @Autowired
    private RecordRepository recordRepository;

    @Bean
    public Mediator mediator() {
        Mediator mediator = new Mediator();
        configureHandlers(mediator);
        return mediator;
    }

    public void configureHandlers(Mediator mediator) {
        mediator.registerHandler(AddRecordCommand.class, new RecordCommandHandler(recordRepository));
        mediator.registerHandler(GetKmRunQuery.class, new KmRunHandler(recordRepository));
        mediator.registerHandler(GetDrinkingWaterQuery.class, new DrinkingWaterHandler(recordRepository));
        mediator.registerHandler(GetHoursAtTheGymQuery.class, new HoursAtTheGymHandler(recordRepository));
    }

}
