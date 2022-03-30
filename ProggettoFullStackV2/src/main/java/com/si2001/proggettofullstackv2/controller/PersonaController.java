package com.si2001.proggettofullstackv2.controller;

import com.si2001.proggettofullstackv2.persistence.Persona;
import com.si2001.proggettofullstackv2.persistence.PersonaRepository;
import com.si2001.proggettofullstackv2.persistence.Utenti;
import com.si2001.proggettofullstackv2.persistence.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@SessionAttributes({"loggedId", "isAdmin"})
public class PersonaController {

    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    UtentiRepository utentiRepository;

    @GetMapping("savePersona")
    public ModelAndView getSavePersona(@ModelAttribute("isAdmin") boolean isAdmin) {

        if (isAdmin) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("addPersona");
            mv.addObject("persona", new Persona());
            return mv;
        } else {
            System.out.println("Not an admin, invalid URL");
            return new ModelAndView("redirect:/login");
        }
    }

    @GetMapping("UpdatePersona")
    public ModelAndView getUpdatePersona(@RequestParam int userId, @ModelAttribute("isAdmin") boolean isAdmin) {

        if (isAdmin) {
            Persona tmpPersona = personaRepository.getById(userId);
            ModelAndView mv = new ModelAndView();
            mv.setViewName("addPersona");
            mv.addObject("persona", tmpPersona);
            return mv;

        } else {
            System.out.println("Not an admin, invalid URL");
            return new ModelAndView("redirect:/login");
        }

    }

    @GetMapping("UpdateProfilo")
    public ModelAndView getUpdateProfilo(@ModelAttribute("isAdmin") boolean isAdmin, @ModelAttribute("loggedId") int loggedId) {
        if (loggedId > 0) {
            Persona tmpPersona = personaRepository.getById(loggedId);
            ModelAndView mv = new ModelAndView();
            mv.setViewName("addPersona");
            Utenti tmpUtenti = utentiRepository.findByPersona(tmpPersona);
            mv.addObject("persona", tmpPersona);
            mv.addObject("utenteId", tmpUtenti.getId());
            return mv;
        } else {
            System.out.println("Not an admin, invalid URL");
            return new ModelAndView("redirect:/login");
        }
    }


    @GetMapping("deletePersona")
    public ModelAndView deletePersona(@RequestParam int userId, @ModelAttribute("isAdmin") boolean isAdmin) {
        if (isAdmin) {
            personaRepository.deleteById(userId);
            return new ModelAndView("redirect:/");
        } else {
            System.out.println("Not an admin, invalid URL");
            return new ModelAndView("redirect:/login");
        }
    }

    @PostMapping("personaPost")
    public ModelAndView personaPost(@RequestParam int id, @RequestParam String nome, @RequestParam String cognome, @RequestParam String nascita, @ModelAttribute("isAdmin") boolean isAdmin, @ModelAttribute("loggedId") int loggedId) {
        if (!isAdmin) {
            if (id == loggedId) {
            } else {
                System.out.println("Not an admin, not himself, invalid URL");
                return new ModelAndView("redirect:/login");
            }
        }

        Persona tmpPersona;
        if (id != 0) {
            tmpPersona = new Persona(id, nome, cognome, LocalDate.parse(nascita));
        } else {
            tmpPersona = new Persona(nome, cognome, LocalDate.parse(nascita));
        }
        personaRepository.save(tmpPersona);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addUtente");
        modelAndView.addObject("personaId", tmpPersona.getId());
        Utenti tmpUtenti;
        if (id > 0) {
            tmpUtenti = utentiRepository.findByPersona(tmpPersona);
            if (tmpUtenti == null) {
                System.out.println("Trovato null PersonController 82 circa riga");
                tmpUtenti = new Utenti();
            }
        } else {
            tmpUtenti = new Utenti();
        }
        modelAndView.addObject("utente", tmpUtenti);
        return modelAndView;
    }

    @PostMapping("utentiPost")
    public ModelAndView utentiPost(@RequestParam String email, @RequestParam String password, @RequestParam String admin, @RequestParam int persona, @RequestParam int id, @ModelAttribute("isAdmin") boolean isAdmin, @ModelAttribute("loggedId") int loggedId) {

        if (!isAdmin) {
            if (id == loggedId) {
            } else {
                System.out.println("Not an admin, not himself, invalid URL");
                return new ModelAndView("redirect:/login");
            }
        }

        Utenti tmpUtente = new Utenti(id, email, password, Boolean.parseBoolean(admin), personaRepository.getById(persona));
        utentiRepository.save(tmpUtente);
        return new ModelAndView("redirect:/");
    }

}
