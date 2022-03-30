package com.si2001.proggettofullstackv2.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Utenti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    @NotNull
    @Size(min = 2)
    String email;
    @NotNull
    @Size(min = 2)
    String password;
    boolean isAdmin=false;
    @OneToOne
    Persona persona;
    //Relazione a persona

    public Utenti() {
    }

    public Utenti(int id, String email, String password, boolean isAdmin, Persona persona) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.persona = persona;
    }

    public Utenti(String email, String password, boolean isAdmin, Persona persona) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.persona = persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Utenti{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", persona=" + persona +
                '}';
    }
}
