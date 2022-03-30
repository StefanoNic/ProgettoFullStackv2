package com.si2001.proggettofullstackv2.controller;
import com.si2001.proggettofullstackv2.service.LoginServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@SessionAttributes({"loggedId", "isAdmin"})
public class LoginController {

    @Autowired
    LoginServiceInterface loginService;
    @PostMapping("loginCheck")
    public ModelAndView loginCheck(@RequestParam String emailName, @RequestParam String passwordName){


        int foundUser = loginService.check(emailName, passwordName);
        System.out.println(emailName + "  " + passwordName + " " + foundUser);
        boolean isAdmin = false;
        Integer loggedId;
        if(foundUser > 0) {
            isAdmin = loginService.isAdmin(emailName);
            loggedId= foundUser;
        }
        else {
            loggedId = 0;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("loggedId", loggedId);
        mv.addObject("isAdmin", isAdmin);
        mv.setViewName("home");
        return mv;
    }

    @GetMapping("Logout")
    public ModelAndView logout(@ModelAttribute("isAdmin") boolean isAdmin, @ModelAttribute("loggedId") int loggedId){
        isAdmin= false;
        loggedId = 0;
        ModelAndView mv = new ModelAndView();
        mv.addObject("loggedId", loggedId);
        mv.addObject("isAdmin", isAdmin);
        mv.setViewName("login");
        return mv;
    }

}
