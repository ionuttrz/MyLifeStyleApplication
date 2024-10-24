package com.ProiectareSoftware.myLifeStyle.strategy.chartperiod;

import com.ProiectareSoftware.myLifeStyle.model.Record;

import java.util.List;

public interface IStrategy {

    List<Float> getListOfDays(List<Record> recordList, String strategy);

}
