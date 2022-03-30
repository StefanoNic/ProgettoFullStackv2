package com.si2001.proggettofullstackv2.persistence;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    Persona persona;

    @OneToOne
    Veicolo veicolo;

    LocalDate dataInizio;
    LocalDate dataFine;
    boolean approved;

    public Prenotazione() {
    }

    public Prenotazione(Persona persona, Veicolo veicolo, LocalDate dataInizio, LocalDate dataFine) {
        this.persona = persona;
        this.veicolo = veicolo;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.approved=false;
    }

    public Prenotazione(Persona persona, Veicolo veicolo, LocalDate dataInizio, LocalDate dataFine, boolean approved) {
        this.persona = persona;
        this.veicolo = veicolo;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.approved = approved;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", veicolo=" + veicolo +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", approved=" + approved +
                '}';
    }
}
