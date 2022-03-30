package com.si2001.proggettofullstackv2.controller;


import com.si2001.proggettofullstackv2.persistence.Persona;
import com.si2001.proggettofullstackv2.persistence.Prenotazione;
import com.si2001.proggettofullstackv2.persistence.Utenti;
import com.si2001.proggettofullstackv2.service.ProfiloUtenteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@SessionAttributes("loggedId")
public class ProfiloUtenteController {

    @Autowired
    ProfiloUtenteServiceInterface profiloUtenteService;

    @GetMapping("ProfiloUtente")
    public ModelAndView requestProfiloUtente(@ModelAttribute("loggedId") Integer loggedId){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("profiloUtente");
        Utenti tmpUtente = profiloUtenteService.getUtente(loggedId);
        Persona tmpPersona = profiloUtenteService.getPersona(tmpUtente);
        mv.addObject("utente", tmpUtente);
        mv.addObject("persona", tmpPersona);
        return mv;
    }

}
