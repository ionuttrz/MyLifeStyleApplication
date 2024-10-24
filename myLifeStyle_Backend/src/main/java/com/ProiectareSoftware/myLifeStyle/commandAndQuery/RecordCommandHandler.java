package com.ProiectareSoftware.myLifeStyle.commandAndQuery;

import com.ProiectareSoftware.myLifeStyle.dto.AddRecordCommand;
import com.ProiectareSoftware.myLifeStyle.model.Record;
import com.ProiectareSoftware.myLifeStyle.repository.RecordRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RecordCommandHandler implements RequestHandler<AddRecordCommand, Record> {

    @Autowired
    RecordRepository recordRepository;

    @Override
    public Record handle(AddRecordCommand addRecordCommand) {
        String email = addRecordCommand.getAccessToken().getName();
        Boolean isDate = recordRepository.existsByDateAndEmailUser(addRecordCommand.getDate(), email);
        System.out.println(isDate);
        /*if (isDate) {
            System.out.println("This date was already used in a record.");
            return null;
        }*/

        // Create new entry in table
        Record record = new Record();

        record.setEmailUser(email);
        record.setDate(addRecordCommand.getDate());
        record.setKmRun(addRecordCommand.getKmRun());
        record.setHoursAtTheGym(addRecordCommand.getHoursAtTheGym());
        record.setDrinkingWater(addRecordCommand.getDrinkingWater());

        record = recordRepository.save(record);

        return record;
    }
}
