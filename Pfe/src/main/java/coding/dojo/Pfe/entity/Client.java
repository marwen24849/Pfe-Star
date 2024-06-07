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
public class Client extends Utilisateur {

    @OneToMany(mappedBy = "client")
    private List<Location> historiqueLocations;

    // Getters and setters
    // Constructor
}