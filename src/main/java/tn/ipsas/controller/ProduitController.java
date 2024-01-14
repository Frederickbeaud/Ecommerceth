package tn.ipsas.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.ipsas.model.Client;
import tn.ipsas.model.Product;
import tn.ipsas.repository.ClientReposirory;
import tn.ipsas.repository.ProductRepository;

import java.util.Collection;

@Controller // pour déclarer un contrôleur
@RequestMapping(value = "/produits") @AllArgsConstructor
public class ProduitController {
    private ProductRepository prodReposirory;
    @RequestMapping(value = "/all")
    public String index(Model model){
        Collection<Product> produits = prodReposirory.findAll();
        model.addAttribute("produits",produits);
        return "produits";
    }
}
