package com.si2001.proggettofullstackv2.service;

import com.si2001.proggettofullstackv2.persistence.Prenotazione;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class CheckService implements CheckInterface{
    @Override
    public boolean checkInizioPrenotazione(Prenotazione prenotazione) {

        LocalDate today = LocalDate.now();
        long daysBetween = DAYS.between(prenotazione.getDataFine(), today);
        return daysBetween > 2;
    }
}
