package com.ProiectareSoftware.myLifeStyle.strategy.chartperiod;

public class Strategy {

    public static IStrategy getDays(int days) throws IllegalAccessException {
        switch (days) {
            case 6:
                return new StrategyWeek();
            case 29:
                return new StrategyMonth();

            default: throw new IllegalAccessException();
        }
    }
}
