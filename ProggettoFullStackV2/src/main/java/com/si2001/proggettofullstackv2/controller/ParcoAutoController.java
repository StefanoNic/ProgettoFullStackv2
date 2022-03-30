package com.si2001.proggettofullstackv2.controller;

import com.si2001.proggettofullstackv2.persistence.Persona;
import com.si2001.proggettofullstackv2.persistence.Veicolo;
import com.si2001.proggettofullstackv2.persistence.VeicoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RestController
@SessionAttributes("isAdmin")
public class ParcoAutoController {

    @Autowired
    VeicoloRepository veicoloRepository;
    
    @RequestMapping("ParcoAuto")
    public ModelAndView requestParcoAuto(){
        List<Veicolo> veicoliList = veicoloRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("veicoliList", veicoliList);
        mv.setViewName("parcoAuto");
        return mv;
    }

    @GetMapping("saveVeicolo")
    public ModelAndView getSaveVeicolo(@ModelAttribute("isAdmin") boolean isAdmin) {

        if (isAdmin) {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("addVeicolo");
            mv.addObject("veicolo", new Veicolo());
            return mv;
        } else {
            System.out.println("Not an admin, invalid URL");
            return new ModelAndView("redirect:/login");
        }
    }

    @GetMapping("UpdateVeicolo")
    public ModelAndView getUpdateVeicolo(@RequestParam int veicoloId, @ModelAttribute("isAdmin") boolean isAdmin) {

        if (isAdmin) {
            Veicolo tmpVeicolo = veicoloRepository.getById(veicoloId);
            ModelAndView mv = new ModelAndView();
            mv.setViewName("addVeicolo");
            mv.addObject("veicolo", tmpVeicolo);
            return mv;

        } else {
            System.out.println("Not an admin, invalid URL");
            return new ModelAndView("redirect:/login");
        }
    }


    @GetMapping("deleteVeicolo")
    public ModelAndView deleteVeicolo(@RequestParam int veicoloId, @ModelAttribute("isAdmin") boolean isAdmin) {
        if (isAdmin) {
            veicoloRepository.deleteById(veicoloId);
            return new ModelAndView("redirect:/ParcoAuto");
        } else {
            System.out.println("Not an admin, invalid URL");
            return new ModelAndView("redirect:/login");
        }
    }

    @PostMapping("postVeicolo")
    public ModelAndView postVeicolo(@RequestParam int id, @RequestParam String targa, @RequestParam String modello, @RequestParam String immatricolazione, @RequestParam String tipologia, @ModelAttribute("isAdmin") boolean isAdmin) {
        if (isAdmin) {
            Veicolo tmpVeicolo;
            if (id != 0) {
                tmpVeicolo = new Veicolo(id, targa, modello, LocalDate.parse(immatricolazione), tipologia);
            } else {
                tmpVeicolo = new Veicolo(targa, modello, LocalDate.parse(immatricolazione), tipologia);
            }
            veicoloRepository.save(tmpVeicolo);
            return new ModelAndView("redirect:/ParcoAuto");

        } else {
            System.out.println("Not an admin, invalid URL");
            return new ModelAndView("redirect:/login");
        }

    }

}
