package ma.fstt.commandeservice.web;

import ma.fstt.commandeservice.entities.Commande;
import ma.fstt.commandeservice.models.Product;
import ma.fstt.commandeservice.models.User;
import ma.fstt.commandeservice.openFeign.ProductFeignClient;
import ma.fstt.commandeservice.openFeign.UserFeignClient;
import ma.fstt.commandeservice.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommandeRestController {
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private ProductFeignClient productFeignClient;

    @GetMapping("/commande/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        Commande commande = commandeRepository.findById(id).get();
        User user = userFeignClient.getUserById(commande.getUserId());
        commande.setUser(user);
        commande.getLignesCommande().forEach(ligneCommande -> {
            Product product = productFeignClient.getProductById(ligneCommande.getProduit_id());
            ligneCommande.setProduct(product);
        });
        return commande;
    }
}
