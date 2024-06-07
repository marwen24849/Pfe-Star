package coding.dojo.Pfe.service;

import coding.dojo.Pfe.entity.Vehicule;
import coding.dojo.Pfe.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public ResponseEntity<Vehicule> getVehiculeById(Long id) {
        Optional<Vehicule> vehicule = vehiculeRepository.findById(id);
        if (vehicule.isPresent()) {
            return new ResponseEntity<>(vehicule.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Vehicule>> getAllVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        return new ResponseEntity<>(vehicules, HttpStatus.OK);
    }

    public ResponseEntity<List<Vehicule>> getVehiculesByDisponibilite(boolean disponible) {
        List<Vehicule> vehicules = vehiculeRepository.findByDisponible(disponible);
        return new ResponseEntity<>(vehicules, HttpStatus.OK);
    }

    public ResponseEntity<Vehicule> createVehicule(Vehicule vehicule) {
        Vehicule savedVehicule = vehiculeRepository.save(vehicule);
        return new ResponseEntity<>(savedVehicule, HttpStatus.CREATED);
    }

    public ResponseEntity<Vehicule> updateVehicule(Long id, Vehicule vehiculeDetails) {
        Optional<Vehicule> vehicule = vehiculeRepository.findById(id);
        if (vehicule.isPresent()) {
            Vehicule updatedVehicule = vehicule.get();
            updatedVehicule.setMarque(vehiculeDetails.getMarque());
            updatedVehicule.setModele(vehiculeDetails.getModele());
            updatedVehicule.setImmatriculation(vehiculeDetails.getImmatriculation());
            updatedVehicule.setPrixParJour(vehiculeDetails.getPrixParJour());
            updatedVehicule.setDisponible(vehiculeDetails.isDisponible());
            vehiculeRepository.save(updatedVehicule);
            return new ResponseEntity<>(updatedVehicule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> deleteVehicule(Long id) {
        Optional<Vehicule> vehicule = vehiculeRepository.findById(id);
        if (vehicule.isPresent()) {
            vehiculeRepository.delete(vehicule.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
