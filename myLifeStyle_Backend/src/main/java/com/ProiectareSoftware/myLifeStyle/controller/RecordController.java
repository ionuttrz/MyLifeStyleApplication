package com.ProiectareSoftware.myLifeStyle.controller;

import com.ProiectareSoftware.myLifeStyle.commandAndQuery.Mediator;
import com.ProiectareSoftware.myLifeStyle.decorator.ChartColor;
import com.ProiectareSoftware.myLifeStyle.decorator.IChartColor;
import com.ProiectareSoftware.myLifeStyle.dto.AddRecordCommand;
import com.ProiectareSoftware.myLifeStyle.dto.GetKmRunQuery;
import com.ProiectareSoftware.myLifeStyle.dto.GetHoursAtTheGymQuery;
import com.ProiectareSoftware.myLifeStyle.dto.GetDrinkingWaterQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/record")
@CrossOrigin(origins = "*")
public class RecordController {

    @Autowired
    Mediator mediator;

    @PostMapping("/addRecord")
    public ResponseEntity<?> addNewRecord(Authentication accessToken, @RequestBody AddRecordCommand command) {
        command.setAccessToken(accessToken);
        return ResponseEntity.ok(mediator.send(command));
    }

    @GetMapping("/getKm")
    public ResponseEntity<?> getKm(Authentication accessToken, @RequestParam int days) throws IllegalAccessException {
        GetKmRunQuery query = new GetKmRunQuery(accessToken, days);
        HashMap<String, Object> responseData = new HashMap<>();
        List<Float> data = mediator.send(query);
        responseData.put("data", data);
        IChartColor iChartColor = new ChartColor();
        String background = iChartColor.setColor(data, "km");
        responseData.put("backgroundColor", background);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/getHoursAtGym")
    public ResponseEntity<?> getHoursAtGym(Authentication accessToken, @RequestParam int days) throws IllegalAccessException {
        GetHoursAtTheGymQuery query = new GetHoursAtTheGymQuery(accessToken, days);
        HashMap<String, Object> responseData = new HashMap<>();
        List<Float> data = mediator.send(query);
        responseData.put("data", data);
        IChartColor iChartColor = new ChartColor();
        String background = iChartColor.setColor(data, "hoursAtGym");
        responseData.put("backgroundColor", background);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/getDrinkingWater")
    public ResponseEntity<?> getDrinkingWater(Authentication accessToken, @RequestParam int days) throws IllegalAccessException {
        GetDrinkingWaterQuery query = new GetDrinkingWaterQuery(accessToken, days);
        HashMap<String, Object> responseData = new HashMap<>();
        List<Float> data = mediator.send(query);
        responseData.put("data", data);
        IChartColor iChartColor = new ChartColor();
        String background = iChartColor.setColor(data, "drinkingWater");
        responseData.put("backgroundColor", background);
        return ResponseEntity.ok(responseData);
    }
}
