package com.si2001.proggettofullstackv2.service;

import com.si2001.proggettofullstackv2.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfiloUtenteService implements  ProfiloUtenteServiceInterface{

    @Autowired
    UtentiRepository utentiRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    PrenotazioneRepository prenotazioneRepository;


    @Override
    public Utenti getUtente(Integer loggedId) {
        return utentiRepository.getById(loggedId);
    }

    @Override
    public Persona getPersona(Utenti tmpUtente) {
        return tmpUtente.getPersona();
    }

    @Override
    public Persona getPersona(Integer loggedId) {
        Utenti tmpUtente = utentiRepository.getById(loggedId);
        return tmpUtente.getPersona();
    }

    @Override
    public List<Prenotazione> getPrenotazioni(Utenti tmpUtente) {
        Persona tmpPersona = this.getPersona(tmpUtente);
        return prenotazioneRepository.findByPersona(tmpPersona);
    }
}
