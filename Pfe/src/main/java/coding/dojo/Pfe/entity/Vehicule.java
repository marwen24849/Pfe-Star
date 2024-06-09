package coding.dojo.Pfe.entity;

import jakarta.persistence.*;
import jakarta.persistence.InheritanceType;
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
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marque;
    private String modele;
    private String Type;
    private String immatriculation;
    private float prixParJour;
    private boolean disponible;
    @Enumerated(EnumType.STRING)
    private TypeVehicule typeVehicule;

    @ManyToOne
    private Categorie categorie;

    @OneToMany
    private List<Avis> avis;


}