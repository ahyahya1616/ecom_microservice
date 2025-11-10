package ma.fstt.commandeservice.repositories;

import ma.fstt.commandeservice.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {
}
