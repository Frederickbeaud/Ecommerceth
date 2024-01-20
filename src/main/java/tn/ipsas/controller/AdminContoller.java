package tn.ipsas.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tn.ipsas.model.Categorie;
import tn.ipsas.model.Client;
import tn.ipsas.model.Product;
import tn.ipsas.repository.CategorieRepository;
import tn.ipsas.repository.ClientReposirory;
import tn.ipsas.repository.ProductRepository;

import java.util.Collection;
import java.util.List;

@Controller // pour déclarer un contrôleur
@AllArgsConstructor

public class AdminContoller {
    private ProductRepository prodReposirory;
    private ClientReposirory clientReposirory;
    private CategorieRepository categorieReposirory;

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
    @RequestMapping(value = "/categorie")
    public String categorie(Model model){
        Collection<Categorie> categories = categorieReposirory.findAll();
        model.addAttribute("categories",categories);
        return "categorie";
    }
    @RequestMapping(value = "/produitsAdmin") // nom logique pour accéder à l'action "index" ou méthode "index
    public String index (Model model,
// paramètre pour le numéro de la page (0 par défaut)
                         @RequestParam (name="page" , defaultValue ="0") int p,
// paramètre "motCle"
                         @RequestParam (name="motCle", defaultValue="") String mc)
    {
// récupérer la page numero "p" (de taille 6)
        Page <Product> pg =

                prodReposirory.findByLibelleLike("%"+mc+"%", PageRequest.of(p, 6));

// nombre total des pages
        int nbrePages =pg.getTotalPages();
// créer un tableau d'entier qui contient les numéros des pages
        int [] pages = new int[nbrePages];
        for(int i= 0 ; i< nbrePages; i++)
        {
            pages[i]=i;
        }
// placer le tableau dans le "Model"
        model.addAttribute("pages", pages);
// placer la page des produits dans le "Model" comme un attribut"

        model.addAttribute("pageProduits", pg.getContent());
// retourner le numéro de la page courante
        model.addAttribute("pageCourante",p);
// retourner la valeur du mot clé
        model.addAttribute("motCle", mc);
//retourner le nom de la vue WEB à afficher

        return "AdminProduit"; //retourner le nom de la vue WEB à afficher
    }
    @RequestMapping(value="/form",method= RequestMethod.GET)
    public String formProduit (Model model)
    {   Collection<Categorie> cats =  categorieReposirory.findAll();
//placer un objet de type "Produit" dans le modèle
        model.addAttribute("produit", new Product());
        model.addAttribute("categories", cats);

//retourner le nom de la vue WEB à afficher (le formulaire)
        return "formProduit";
    }
    @RequestMapping(value="/save",method=RequestMethod.POST)
    public String save (Model model, @Valid Product produit , BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
// en cas d'erreurs de validation
            return "formProduit";
//sinon
//enregistrer le produit dans la BD
        prodReposirory.save(produit);
        model.addAttribute("produit",produit);
//Afficher une page pour confirmer l'enregistrement
        return "confirmation";
    }
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public String delete (Long id, int page, String motCle)
    {
        prodReposirory.deleteById(id);
        return "redirect:produitsAdmin?page="+page+"&motCle="+motCle;
    }
    @RequestMapping(value="/edit",method=RequestMethod.GET)
    public String edit (Model model,
                        @RequestParam (name="id")Long id)

    {
// récupérer l'objet ayant l'id spécifié
        Product p =(Product) prodReposirory.findById(id).orElse(null);
// placer le produit trouvé dans le modèle
        Collection<Categorie> cats =  categorieReposirory.findAll();
//placer un objet de type "Produit" dans le modèle

        model.addAttribute("categories", cats);

        model.addAttribute("produit", p);
// rediriger l'affichage vers la vue "editProduit"
        return "editProduit";
    }
    @RequestMapping(value="/update",method=RequestMethod.POST)
    public String update (Model model, @Valid Product produit ,
                          BindingResult bindingResult) {

        if (bindingResult.hasErrors())
// en cas d'erreurs de validation
            return "editProduit";
//enregistrer le produit dans la BD
        prodReposirory.save(produit);
//Afficher une page pour confirmer l'enregistrement
        return "confirmation";

    }
}
