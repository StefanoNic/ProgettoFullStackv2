package com.si2001.proggettofullstackv2.controller;

import com.si2001.proggettofullstackv2.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@SessionAttributes({"loggedId", "isAdmin"})
public class ElencoPrenotazioniController {

    @Autowired
    PrenotazioneRepository prRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    VeicoloRepository veicoloRepository;

    @RequestMapping("ElencoPrenotazioni")
    public ModelAndView requestElencoPrenotazioni(){
        List<Prenotazione> prenotazioneList = prRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("prenotazioneList",prenotazioneList);
        mv.setViewName("prenotazioneUtenteAdmin");
        return mv;
    }



    @GetMapping("getPrenotazioni")
    public ModelAndView getPrenotazioni(@RequestParam int userId, @ModelAttribute("isAdmin") boolean isAdmin){
        if (isAdmin) {
            Persona tmpPersona = personaRepository.getById(userId);
            List<Prenotazione> tmpPrenotazioni = prRepository.findByPersona(tmpPersona);
            ModelAndView mv = new ModelAndView();
            mv.addObject("prenotazioneList", tmpPrenotazioni);
            mv.setViewName("prenotazioneUtenteAdmin");
            return mv;
        }
        else {
            System.out.println("Not an admin, invalid URL");
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping("getPersonalPrenotazioni")
    public ModelAndView getPersonalPrenotazioni(@ModelAttribute("loggedId") int loggedId) {
        Persona tmpPersona = personaRepository.getById(loggedId);
        List<Prenotazione> tmpPrenotazioni = prRepository.findByPersona(tmpPersona);
        ModelAndView mv = new ModelAndView();
        mv.addObject("prenotazioneList", tmpPrenotazioni);
        mv.setViewName("component/homeUser");
        return mv;
    }

    @GetMapping("approvaPrenotazione")
    public ModelAndView approvaPrenotazioni(@RequestParam int prenotazioneId, @ModelAttribute("isAdmin") boolean isAdmin, HttpServletRequest request){

        if (isAdmin) {
            Prenotazione tmpPrenotazione = prRepository.getById(prenotazioneId);
            tmpPrenotazione.setApproved(true);
            prRepository.save(tmpPrenotazione);
            String referer = request.getHeader("Referer");
            String[] segments = referer.split("/");
            String idStr = segments[segments.length-1];
            return new ModelAndView("redirect:/" + idStr);
        }
        else {
            System.out.println("Not an admin, invalid URL");
            return new ModelAndView("redirect:/login");
        }


    }

    @GetMapping("deletePrenotazione")
    public ModelAndView deletePrenotazione(@RequestParam int prenotazioneId, @ModelAttribute("isAdmin") boolean isAdmin, HttpServletRequest request){

        if (isAdmin) {
            prRepository.deleteById(prenotazioneId);
            String referer = request.getHeader("Referer");
            String[] segments = referer.split("/");
            String idStr = segments[segments.length-1];
            return new ModelAndView("redirect:/" + idStr);
        }
        else {
            System.out.println("Not an admin, invalid URL");
            return new ModelAndView("redirect:/login");
        }


    }


    @GetMapping("deletePrenotazioneUser")
    public ModelAndView deletePrenotazioneUser(@RequestParam int prenotazioneId, @ModelAttribute("loggedId") int loggedId) {

        Prenotazione tmpPrenotazione = prRepository.getById(prenotazioneId);
        Persona tmpPersona = tmpPrenotazione.getPersona();
        if (loggedId == tmpPersona.getId()) {
            prRepository.deleteById(prenotazioneId);
            return new ModelAndView("redirect:/");
        } else{
            System.out.println("Non puoi eliminare le prenotazioni degli altri");
            return new ModelAndView("redirect:/login");
        }
    }

    @GetMapping("updatePrenotazione")
    public ModelAndView updatePrenotazione(@RequestParam int prenotazioneId, @ModelAttribute("loggedId") int loggedId) {

        Prenotazione tmpPrenotazione = prRepository.getById(prenotazioneId);
        Persona tmpPersona = tmpPrenotazione.getPersona();
        if (loggedId == tmpPersona.getId()) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("addPrenotazione");
            mv.addObject("tmpPrenotazione", tmpPrenotazione);
            List<Veicolo> veicoloList =  veicoloRepository.findAll();
            mv.addObject("listOfVehicle",veicoloList);
            return mv;
        } else{
            System.out.println("Non puoi modificare le prenotazioni degli altri");
            return new ModelAndView("redirect:/login");
        }
    }

    @GetMapping("addPrenotazione")
    public ModelAndView addPrenotazione(@ModelAttribute("loggedId") int loggedId) {

            Prenotazione tmpPrenotazione = new Prenotazione();
            ModelAndView mv = new ModelAndView();
            mv.setViewName("addPrenotazione");
            mv.addObject("tmpPrenotazione", tmpPrenotazione);
            List<Veicolo> veicoloList =  veicoloRepository.findAll();
            mv.addObject("listOfVehicle",veicoloList);
            return mv;

    }
}
