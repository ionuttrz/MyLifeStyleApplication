package com.ProiectareSoftware.myLifeStyle.decorator;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ChartColor implements IChartColor {
    String red = "rgba(255, 0, 0, 0.8)";
    String green = "rgba(0, 255, 0, 0.8)";

    @Override
    public String setColor(List<Float> list, String chartType) {
        float avg = 0;
        int count = 0;
        for (Float i : list) {
            if (i != 0) {
                count++;
                avg += i;
            }
        }
        avg = avg / count;

        switch (chartType) {
            case "km":
                if (avg < 4) {
                    return red;
                }
                break;
            case "hoursAtGym":
                if (avg < 1) {
                    return red;
                }
                break;
            case "drinkingWater":
                if (avg < 2) {
                    return red;
                }
                break;
        }

        return green;
    }
}
