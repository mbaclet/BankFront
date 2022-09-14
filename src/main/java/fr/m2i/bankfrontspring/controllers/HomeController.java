package fr.m2i.bankfrontspring.controllers;

import fr.m2i.bankfrontspring.models.Compte;
import fr.m2i.bankfrontspring.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    CompteService cs;

    @GetMapping(path = "/home")
    public String home(Model model){
        Iterable<Compte> comptes = cs.getComptes();

        model.addAttribute("comptes", comptes);


        return "structure";
    }

}
