package ma.fstt.commandeservice.repositories;

import ma.fstt.commandeservice.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
