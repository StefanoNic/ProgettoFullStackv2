package com.si2001.proggettofullstackv2.service;

import com.si2001.proggettofullstackv2.persistence.Utenti;
import com.si2001.proggettofullstackv2.persistence.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class LoginService implements LoginServiceInterface{

    @Autowired
    UtentiRepository repository;

    @Override
    public int check(String emailName, String passwordName) {
        Utenti utente = (Utenti) repository.findByEmail(emailName);
        if (utente != null) {
            if (passwordName.equals(utente.getPassword())){
                return utente.getId();
            }
        }
        return 0;
    }

    @Override
    public boolean isAdmin(String emailName) {
        Utenti utente = (Utenti) repository.findByEmail(emailName);
        return  utente.isAdmin();
    }

}
