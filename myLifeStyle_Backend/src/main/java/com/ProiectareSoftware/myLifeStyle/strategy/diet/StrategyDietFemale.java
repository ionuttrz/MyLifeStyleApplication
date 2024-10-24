package com.ProiectareSoftware.myLifeStyle.strategy.diet;

import com.ProiectareSoftware.myLifeStyle.dto.request.DietRequest;

public class StrategyDietFemale implements IDietStrategy{
    @Override
    public Float calculateRMB(DietRequest dietRequest, String gender) {
        Float RMB = (float) (655+
                        (9.5 * dietRequest.getMass())+
                        (1.8 * dietRequest.getHeight())-
                        (4.7 * dietRequest.getAge()));
        System.out.println(RMB);
        return RMB;
    }
}
