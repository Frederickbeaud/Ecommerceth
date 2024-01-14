package tn.ipsas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.ipsas.model.Categorie;
import tn.ipsas.model.Client;
import tn.ipsas.repository.CategorieRepository;
import tn.ipsas.repository.ClientReposirory;
import tn.ipsas.repository.ProductRepository;

import java.util.ArrayList;

@SpringBootApplication
public class EcommerceThymleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceThymleafApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ClientReposirory clientRepository , ProductRepository productRepository, CategorieRepository categorieRepository)
	{
		return args ->
		{
//Insérer trois clients de test dans la BD
			clientRepository.save(new Client(null,"Ali","ali.ms@gmail.com"));
			clientRepository.save(new Client(null,"Mariem","Mariem.ms@gmail.com"));
			clientRepository.save(new Client(null,"Mohamed","Mohamed.ms@gmail.com"));
//Afficher les clients existants dans la BD
			for (Client client : clientRepository.findAll())
			{
				System.out.println(client.toString());
			}

			categorieRepository.save(new Categorie(null,"Ordinateur",new ArrayList<>()));
			categorieRepository.save(new Categorie(null,"Telephone",new ArrayList<>()));
			categorieRepository.save(new Categorie(null,"Gaming",new ArrayList<>()));
			for (Categorie cat : categorieRepository.findAll())
			{
				System.out.println("cat créée");
			}
		};
	}
}
