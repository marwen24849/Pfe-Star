package coding.dojo.Pfe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Chauffeur extends Utilisateur {

    private String permisDeConduire;
    private boolean disponibilite;

    @OneToMany
    private List<Avis> avis;


}
