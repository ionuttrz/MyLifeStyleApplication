package com.ProiectareSoftware.myLifeStyle.strategy.chartperiod;

import com.ProiectareSoftware.myLifeStyle.model.Record;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StrategyMonth implements IStrategy{
    @Override
    public List<Float> getListOfDays(List<Record> recordList, String chartType) {
        List<Float> floatList = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = currentDate.minusDays(29);
        for(int i = 0; i<30; i++){
            currentDate = startDate.plusDays(i);
            System.out.println(currentDate);
            LocalDate finalCurrentDate = currentDate;
            Optional<Record> record = recordList.stream()
                    .filter(metrics1 -> LocalDate.ofInstant(metrics1.getDate().toInstant(), ZoneId.systemDefault()).equals(finalCurrentDate))
                    .findFirst();
            System.out.println(record);
            if(record.isPresent()){
                if(chartType.equals("km")) {
                    floatList.add(record.get().getKmRun());
                }
                if(chartType.equals("hoursAtGym")){
                    floatList.add(record.get().getHoursAtTheGym());
                }
                if(chartType.equals("drinkingWater")){
                    floatList.add(record.get().getDrinkingWater());
                }
            }
            else{
                floatList.add(0.0f);
            }
        }
        System.out.println("Lista de intregi este " + floatList);
        return floatList;

    }

}
