package com.si2001.proggettofullstackv2.service;

import com.si2001.proggettofullstackv2.persistence.Persona;
import com.si2001.proggettofullstackv2.persistence.Prenotazione;
import com.si2001.proggettofullstackv2.persistence.Utenti;

import java.util.List;

public interface ProfiloUtenteServiceInterface {

    Utenti getUtente(Integer loggedId);

    Persona getPersona(Utenti tmpUtente);

    Persona getPersona(Integer loggedId);

    List<Prenotazione> getPrenotazioni(Utenti tmpUtente);
}
