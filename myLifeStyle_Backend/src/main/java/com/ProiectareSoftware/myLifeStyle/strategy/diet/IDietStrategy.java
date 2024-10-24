package com.ProiectareSoftware.myLifeStyle.strategy.diet;

import com.ProiectareSoftware.myLifeStyle.dto.request.DietRequest;

public interface IDietStrategy {
    Float calculateRMB(DietRequest dietRequest, String gender);
}
