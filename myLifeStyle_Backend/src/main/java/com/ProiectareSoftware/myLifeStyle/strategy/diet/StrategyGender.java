package com.ProiectareSoftware.myLifeStyle.strategy.diet;

import com.ProiectareSoftware.myLifeStyle.strategy.chartperiod.IStrategy;
import com.ProiectareSoftware.myLifeStyle.strategy.chartperiod.StrategyMonth;
import com.ProiectareSoftware.myLifeStyle.strategy.chartperiod.StrategyWeek;

public class StrategyGender {
    public static IDietStrategy getRMB(String gender) throws IllegalAccessException {
        switch (gender) {
            case "MALE":
                return new StrategyDietMale();
            case "FEMALE":
                return new StrategyDietFemale();

            default: throw new IllegalAccessException();
        }
    }
}
