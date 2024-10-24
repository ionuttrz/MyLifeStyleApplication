package com.ProiectareSoftware.myLifeStyle.strategy.diet;

import com.ProiectareSoftware.myLifeStyle.dto.request.DietRequest;

public class StrategyDietMale implements IDietStrategy{
    @Override
    public Float calculateRMB(DietRequest dietRequest, String gender) {
        Float RMB = (float) (66+
                    (13.7 * dietRequest.getMass())+
                    (5 * dietRequest.getHeight())-
                    (6.8 * dietRequest.getAge()));
        System.out.println(RMB);
        return RMB;
    }
}
