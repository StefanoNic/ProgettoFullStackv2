package com.si2001.proggettofullstackv2.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

    List<Prenotazione> findByPersona(Persona persona);
}