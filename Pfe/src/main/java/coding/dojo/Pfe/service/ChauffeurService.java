package coding.dojo.Pfe.service;

import coding.dojo.Pfe.entity.Chauffeur;
import coding.dojo.Pfe.repository.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ChauffeurService {

    @Autowired
    private ChauffeurRepository chauffeurRepository;

    public ResponseEntity<Chauffeur> getChauffeurById(Long id) {
        Optional<Chauffeur> chauffeur = chauffeurRepository.findById(id);
        if (chauffeur.isPresent()) {
            return new ResponseEntity<>(chauffeur.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Chauffeur>> getAllChauffeurs() {
        List<Chauffeur> chauffeurs = chauffeurRepository.findAll();
        return new ResponseEntity<>(chauffeurs, HttpStatus.OK);
    }

    public ResponseEntity<List<Chauffeur>> getChauffeursByDisponibilite(boolean disponibilite) {
        List<Chauffeur> chauffeurs = chauffeurRepository.findByDisponibilite(disponibilite);
        return new ResponseEntity<>(chauffeurs, HttpStatus.OK);
    }

    public ResponseEntity<Chauffeur> createChauffeur(Chauffeur chauffeur) {
        Chauffeur savedChauffeur = chauffeurRepository.save(chauffeur);
        return new ResponseEntity<>(savedChauffeur, HttpStatus.CREATED);
    }

    public ResponseEntity<Chauffeur> updateChauffeur(Long id, Chauffeur chauffeurDetails) {
        Optional<Chauffeur> chauffeur = chauffeurRepository.findById(id);
        if (chauffeur.isPresent()) {
            Chauffeur updatedChauffeur = chauffeur.get();
            updatedChauffeur.setNom(chauffeurDetails.getNom());
            updatedChauffeur.setEmail(chauffeurDetails.getEmail());
            updatedChauffeur.setTelephone(chauffeurDetails.getTelephone());
            updatedChauffeur.setRole(chauffeurDetails.getRole());
            updatedChauffeur.setPermisDeConduire(chauffeurDetails.getPermisDeConduire());
            updatedChauffeur.setDisponibilite(chauffeurDetails.isDisponibilite());
            chauffeurRepository.save(updatedChauffeur);
            return new ResponseEntity<>(updatedChauffeur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> deleteChauffeur(Long id) {
        Optional<Chauffeur> chauffeur = chauffeurRepository.findById(id);
        if (chauffeur.isPresent()) {
            chauffeurRepository.delete(chauffeur.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
