package com.si2001.proggettofullstackv2.controller;

import com.si2001.proggettofullstackv2.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    PersonaRepository personaRepository;

    @RequestMapping("login")
    public ModelAndView requestLogin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("")
    public ModelAndView requestHome(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping("homeAdmin")
    public ModelAndView requestHomeAdmin(){
        List<Persona> personaList= personaRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("component/homeAdmin");
        mv.addObject("personaList",personaList);
        return mv;
    }


}
