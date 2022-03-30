package com.si2001.proggettofullstackv2.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UtentiRepository extends JpaRepository<Utenti, Integer> {

    Utenti findByEmail(String email);
    Utenti findByPersona(Persona persona);
}
