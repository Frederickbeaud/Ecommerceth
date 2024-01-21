package tn.ipsas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.ipsas.model.Categorie;
import tn.ipsas.model.Client;
import tn.ipsas.model.Product;
import tn.ipsas.repository.CategorieRepository;
import tn.ipsas.repository.ClientReposirory;
import tn.ipsas.repository.ProductRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

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


			Categorie cat = categorieRepository.findById(1L).orElseThrow();
			productRepository.save(new Product(null,"Samsung","tres bien" ,2220.0, new Date(),5, cat,"https://www.tunisianet.com.tn/195507-large/ecran-samsung-235-led-full-hd.jpg"));
			for (Product  prod : productRepository.findAll())
			{
				System.out.println("prod créée");
			}
		};
	}
}
