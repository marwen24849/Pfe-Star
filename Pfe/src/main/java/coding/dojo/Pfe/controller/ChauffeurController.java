package coding.dojo.Pfe.controller;

import coding.dojo.Pfe.entity.Chauffeur;
import coding.dojo.Pfe.service.ChauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chauffeurs")
public class ChauffeurController {

    @Autowired
    private ChauffeurService chauffeurService;

    @GetMapping("/{id}")
    public ResponseEntity<Chauffeur> getChauffeurById(@PathVariable Long id) {
        return chauffeurService.getChauffeurById(id);
    }

    @GetMapping
    public ResponseEntity<List<Chauffeur>> getAllChauffeurs() {
        return chauffeurService.getAllChauffeurs();
    }

    @GetMapping("/disponible")
    public ResponseEntity<List<Chauffeur>> getChauffeursByDisponibilite(@RequestParam boolean disponibilite) {
        return chauffeurService.getChauffeursByDisponibilite(disponibilite);
    }

    @PostMapping
    public ResponseEntity<Chauffeur> createChauffeur(@RequestBody Chauffeur chauffeur) {
        return chauffeurService.createChauffeur(chauffeur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chauffeur> updateChauffeur(@PathVariable Long id, @RequestBody Chauffeur chauffeurDetails) {
        return chauffeurService.updateChauffeur(id, chauffeurDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChauffeur(@PathVariable Long id) {
        return chauffeurService.deleteChauffeur(id);
    }
}

