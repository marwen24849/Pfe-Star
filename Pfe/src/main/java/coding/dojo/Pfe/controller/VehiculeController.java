package coding.dojo.Pfe.controller;

import coding.dojo.Pfe.entity.Vehicule;
import coding.dojo.Pfe.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable Long id) {
        return vehiculeService.getVehiculeById(id);
    }

    @GetMapping
    public ResponseEntity<List<Vehicule>> getAllVehicules() {
        return vehiculeService.getAllVehicules();
    }

    @GetMapping("/disponible")
    public ResponseEntity<List<Vehicule>> getVehiculesByDisponibilite(@RequestParam boolean disponible) {
        return vehiculeService.getVehiculesByDisponibilite(disponible);
    }

    @PostMapping
    public ResponseEntity<Vehicule> createVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.createVehicule(vehicule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehiculeDetails) {
        return vehiculeService.updateVehicule(id, vehiculeDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long id) {
        return vehiculeService.deleteVehicule(id);
    }
}

