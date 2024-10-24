package com.ProiectareSoftware.myLifeStyle.repository;

import com.ProiectareSoftware.myLifeStyle.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
    Boolean existsByDateAndEmailUser(Date date, String emailUser);

    @Query("SELECT DISTINCT r FROM Record r WHERE r.date >= :startDate AND r.date <= :endDate AND r.emailUser = :email")
    List<Record> findByDatesInRange(Date startDate, Date endDate, String email);
}
