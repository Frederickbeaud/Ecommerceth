package tn.ipsas.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tn.ipsas.model.Client;
import tn.ipsas.repository.ClientReposirory;

import java.util.Collection;
import java.util.Optional;


@Controller // pour déclarer un contrôleur
@RequestMapping (value = "/client") @AllArgsConstructor
public class ClientController {
    private ClientReposirory clientReposirory;
    @RequestMapping(value = "/index")
    public String index(Model model){
        Collection<Client> clients = clientReposirory.findAll();
        model.addAttribute("client",clients);
        return "clients";
    }
}
