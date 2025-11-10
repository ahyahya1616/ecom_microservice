package ma.fstt.commandeservice.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.fstt.commandeservice.models.Product;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long produit_id;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Commande commande;
    @Transient
    private Product product;

}
