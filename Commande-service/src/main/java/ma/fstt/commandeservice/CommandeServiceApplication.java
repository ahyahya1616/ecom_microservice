package ma.fstt.commandeservice;

import ma.fstt.commandeservice.entities.Commande;
import ma.fstt.commandeservice.entities.LigneCommande;
import ma.fstt.commandeservice.repositories.CommandeRepository;
import ma.fstt.commandeservice.repositories.LigneCommandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class CommandeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandeServiceApplication.class, args);
	}



	@Bean
	CommandLineRunner commandLineRunner(CommandeRepository commandeRepository,
										LigneCommandeRepository ligneCommandeRepository) {
		return args -> {

			// 🧾 Création d'une commande pour un utilisateur (ex: userId = 1)
			Commande commande1 = Commande.builder()
					.userId(1L)
					.total(0.0) // on va le calculer après
					.build();

			commande1 = commandeRepository.save(commande1);

			// 📦 Création des lignes de commande
			LigneCommande ligne1 = LigneCommande.builder()
					.produit_id(1L) // correspond au produit "phone"
					.commande(commande1)
					.build();

			LigneCommande ligne2 = LigneCommande.builder()
					.produit_id(2L) // correspond au produit "tele"
					.commande(commande1)
					.build();

			ligneCommandeRepository.saveAll(List.of(ligne1, ligne2));

			// ⚙️ Calcul du total (ici on peut mettre des valeurs simulées)
			double total = 1000.0 + 10000.0;
			commande1.setTotal(total);
			commandeRepository.save(commande1);

			System.out.println(" Commande et lignes de commande créées avec succès !");
		};
	}
}
