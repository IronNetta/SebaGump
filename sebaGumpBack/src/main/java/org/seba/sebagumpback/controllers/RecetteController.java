package org.seba.sebagumpback.controllers;

import org.seba.sebagumpback.entities.Recette;
import org.seba.sebagumpback.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recettes")
@CrossOrigin(origins = "http://localhost:4200")
public class RecetteController {

    @Autowired
    private RecetteRepository recetteRepository;

    @GetMapping
    public List<Recette> getAllRecettes() {
        return recetteRepository.findAll();
    }

    @PostMapping
    public Recette createRecette(@RequestBody Recette recette) {
        return recetteRepository.save(recette);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recette> getRecetteById(@PathVariable Long id) {
        return recetteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecette(@PathVariable Long id) {
        if (recetteRepository.existsById(id)) {
            recetteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
