package tn.ipsas.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.ipsas.model.Categorie;
import tn.ipsas.repository.CategorieRepository;

import java.util.Collection;

@Controller // pour déclarer un contrôleur
public class HomeController {
    private CategorieRepository categorieRepository;

    public HomeController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @RequestMapping(value = "/home")
    public String acceuil(Model model){
        Collection<Categorie> cats = categorieRepository.findAll();
        model.addAttribute("categories",cats);
        return "Accuil";
    }
}
