package com.ProiectareSoftware.myLifeStyle.service;

import com.ProiectareSoftware.myLifeStyle.dto.UserDTO;
import com.ProiectareSoftware.myLifeStyle.dto.request.DietRequest;
import com.ProiectareSoftware.myLifeStyle.model.User;
import com.ProiectareSoftware.myLifeStyle.repository.UserRepository;
import com.ProiectareSoftware.myLifeStyle.strategy.diet.IDietStrategy;
import com.ProiectareSoftware.myLifeStyle.strategy.diet.StrategyGender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class DietServiceImpl implements DietService {
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> calculateCalories(Authentication accessToken, DietRequest dietRequest) throws IllegalAccessException {
        String email = accessToken.getName();
        User user = userRepository.findByEmail(email).orElse(null);
        String gender = user.getGender();
        IDietStrategy iDietStrategy = StrategyGender.getRMB(gender);
        String activity = dietRequest.getActivity();
        switch(activity){
            case "sedentary":
                return ResponseEntity.ok(1.2 * iDietStrategy.calculateRMB(dietRequest, gender));
            case "average":
                return ResponseEntity.ok(1.375 * iDietStrategy.calculateRMB(dietRequest, gender));
            case "moderate":
                return ResponseEntity.ok(1.55 * iDietStrategy.calculateRMB(dietRequest, gender));
            case "intense":
                return ResponseEntity.ok(1.725 * iDietStrategy.calculateRMB(dietRequest, gender));
            case "veryintense":
                return ResponseEntity.ok(1.9 * iDietStrategy.calculateRMB(dietRequest, gender));

        }
        return ResponseEntity
                .badRequest()
                .body("Error: The activity don't correspond!");
    }
}
