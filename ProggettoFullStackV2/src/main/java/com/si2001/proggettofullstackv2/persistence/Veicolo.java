package com.si2001.proggettofullstackv2.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Veicolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String targa;
    String modello;
    LocalDate immatricolazione;
    String tipologia;

    public Veicolo() {
    }

    public Veicolo(String targa, String modello, LocalDate immatricolazione, String tipologia) {
        this.targa = targa;
        this.modello = modello;
        this.immatricolazione = immatricolazione;
        this.tipologia = tipologia;
    }

    public Veicolo(int id, String targa, String modello, LocalDate immatricolazione, String tipologia) {
        this.id = id;
        this.targa = targa;
        this.modello = modello;
        this.immatricolazione = immatricolazione;
        this.tipologia = tipologia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public LocalDate getImmatricolazione() {
        return immatricolazione;
    }

    public void setImmatricolazione(LocalDate immatricolazione) {
        this.immatricolazione = immatricolazione;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "id=" + id +
                ", targa='" + targa + '\'' +
                ", modello='" + modello + '\'' +
                ", immatricolazione=" + immatricolazione +
                ", tipologia='" + tipologia + '\'' +
                '}';
    }
}