package tn.ipsas.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.ipsas.model.Categorie;
import tn.ipsas.model.Client;
import tn.ipsas.model.Product;
import tn.ipsas.repository.CategorieRepository;
import tn.ipsas.repository.ClientReposirory;
import tn.ipsas.repository.ProductRepository;

import java.util.Collection;

@Controller // pour déclarer un contrôleur
@AllArgsConstructor

public class AdminContoller {
    private ProductRepository prodReposirory;
    private ClientReposirory clientReposirory;
    private CategorieRepository categorieReposirory;
    @RequestMapping(value = "/admin")
    public String admin(){
        return "login";
    }
    @RequestMapping(value = "/")
    public String acceuil(Model model){
        Collection<Categorie> cats = categorieReposirory.findAll();
        model.addAttribute("categories",cats);
        return "Accuil";
    }
    @RequestMapping(value = "/clients")
    public String client(Model model){
        Collection<Client> clients = clientReposirory.findAll();
        model.addAttribute("clients",clients);
        return "clients";
    }
    @RequestMapping(value = "/produits")
    public String produit(Model model){
        Collection<Product> produits = prodReposirory.findAll();
        model.addAttribute("produits",produits);
        return "produitsPanel";
    }
    @RequestMapping(value = "categorie")
    public String categorie(Model model){
        Collection<Categorie> categories = categorieReposirory.findAll();
        model.addAttribute("categories",categories);
        return "categorie";
    }
}
