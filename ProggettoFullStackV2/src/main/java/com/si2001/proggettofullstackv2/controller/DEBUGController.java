package com.si2001.proggettofullstackv2.controller;

import com.si2001.proggettofullstackv2.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class DEBUGController {

    @Autowired
    UtentiRepository utentiRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    VeicoloRepository veicoloRepository;
    @Autowired
    PrenotazioneRepository prenotazioneRepository;




    @RequestMapping("DEBUGAdd")
    public void DEBUGAdd(){
        this.DEBUGAdd2();
        this.DEBUGAdd3();
        this.DEBUGAdd4();
    }

    @RequestMapping("DEBUGAdd2")
    public void DEBUGAdd2(){


        LocalDate myDate1 = LocalDate.of(1990, 2, 23);
        Persona persona1 = new Persona("Nome","Cognome", myDate1);
        personaRepository.save(persona1);

        LocalDate myDate2 = LocalDate.of(1984, 4, 22);
        Persona persona2 = new Persona("Nome2","Cognome2", myDate2);
        personaRepository.save(persona2);

        LocalDate myDate3 = LocalDate.of(2000, 6, 22);
        Veicolo veicolo1 = new Veicolo("Toyota","Bello", myDate3,"Tipologia");
        veicoloRepository.save(veicolo1);

        LocalDate myDate4 = LocalDate.of(2021, 1, 11);
        Veicolo veicolo2 = new Veicolo("Mercedes","Bello", myDate4,"Tipologia2");
        veicoloRepository.save(veicolo2);

        LocalDate myDate5 = LocalDate.of(2020, 1, 10);
        LocalDate myDate6 = LocalDate.of(2020, 5, 4);
        Prenotazione prenotazione1 = new Prenotazione(persona1,veicolo1,myDate5,myDate6);
        prenotazioneRepository.save(prenotazione1);


        return;
    }

    @RequestMapping("DEBUGAdd3")
    public void DEBUGAdd3(){

        Persona persona1 = personaRepository.getById(1);
        Persona persona2 = personaRepository.getById(2);
        Veicolo veicolo1 = veicoloRepository.getById(1);
        Veicolo veicolo2 = veicoloRepository.getById(2);

        LocalDate myDate5 = LocalDate.of(2024, 1, 10);
        LocalDate myDate6 = LocalDate.of(2025, 5, 4);
        Prenotazione prenotazione2 = new Prenotazione(persona1,veicolo1,myDate5,myDate6);
        prenotazioneRepository.save(prenotazione2);

        LocalDate myDate7 = LocalDate.of(1020, 1, 10);
        LocalDate myDate8 = LocalDate.of(1120, 5, 4);
        Prenotazione prenotazione3 = new Prenotazione(persona1,veicolo2,myDate7,myDate8);
        prenotazioneRepository.save(prenotazione3);

        LocalDate myDate9 = LocalDate.of(3000, 1, 10);
        LocalDate myDate10 = LocalDate.of(3030, 5, 4);
        Prenotazione prenotazione4 = new Prenotazione(persona1,veicolo1,myDate9,myDate10);
        prenotazioneRepository.save(prenotazione4);


        Utenti utente2 = new Utenti("admin@email.com", "admin", true, persona1);
        utentiRepository.save(utente2);
        Utenti utente3 = new Utenti("utente@email.com", "utente", false, persona2);
        utentiRepository.save(utente3);
        System.out.println("Added Users!");



    }

    @RequestMapping("DEBUGAdd4")
    public void DEBUGAdd4(){

        Persona persona2 = personaRepository.getById(2);
        Veicolo veicolo1 = veicoloRepository.getById(1);
        Veicolo veicolo2 = veicoloRepository.getById(2);

        LocalDate myDate5 = LocalDate.of(2012, 3, 22);
        LocalDate myDate6 = LocalDate.of(2021, 7, 12);
        Prenotazione prenotazione2 = new Prenotazione(persona2,veicolo1,myDate5,myDate6);
        prenotazioneRepository.save(prenotazione2);

        LocalDate myDate7 = LocalDate.of(2021, 2, 28);
        LocalDate myDate8 = LocalDate.of(2021, 8, 30);
        Prenotazione prenotazione3 = new Prenotazione(persona2,veicolo2,myDate7,myDate8);
        prenotazioneRepository.save(prenotazione3);




    }

}
