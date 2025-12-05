package org.example.sky.controllers;

import lombok.AllArgsConstructor;
import org.example.sky.entities.Moniteur;
import org.example.sky.services.IMoniteurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/moniteur")
public class MoniteurController {

    private final IMoniteurService moniteurService;

    @GetMapping("/retrieve-all-moniteurs")
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurService.retrieveAllMoniteurs();
    }

    @GetMapping("/retrieve-moniteur/{numMoniteur}")
    public Moniteur retrieveMoniteur(@PathVariable("numMoniteur") Long numMoniteur) {
        return moniteurService.retrieveMoniteur(numMoniteur);
    }

    @PostMapping("/add-moniteur")
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.addMoniteur(moniteur);
    }

    @PutMapping("/update-moniteur")
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.updateMoniteur(moniteur);
    }

    @DeleteMapping("/remove-moniteur/{numMoniteur}")
    public void removeMoniteur(@PathVariable("numMoniteur") Long numMoniteur) {
        moniteurService.removeMoniteur(numMoniteur);
    }
}
