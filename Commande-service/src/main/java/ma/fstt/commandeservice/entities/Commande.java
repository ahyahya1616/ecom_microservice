package ma.fstt.commandeservice.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.fstt.commandeservice.models.User;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commande {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Double total;
    private Long userId;
    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> lignesCommande;
    @Transient
    private User user;

}
