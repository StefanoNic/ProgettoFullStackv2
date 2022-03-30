package com.si2001.proggettofullstackv2.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotNull
    @Size(min = 2)
    String nome;

    @NotNull
    @Size(min = 2)
    String cognome;

    @NotNull
    LocalDate nascita;

    public Persona() {
    }

    public Persona(String nome, String cognome, LocalDate nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.nascita = nascita;
    }

    public Persona(int id, String nome, String cognome, LocalDate nascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.nascita = nascita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getNascita() {
        return nascita;
    }

    public void setNascita(LocalDate nascita) {
        this.nascita = nascita;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", nascita=" + nascita +
                '}';
    }
}
