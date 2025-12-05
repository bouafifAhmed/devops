package org.example.sky.controllers;

import lombok.AllArgsConstructor;
import org.example.sky.entities.Piste;
import org.example.sky.services.IPisteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/piste")
public class PisteController {

    private final IPisteService pisteService;

    @GetMapping("/retrieve-all-pistes")
    public List<Piste> retrieveAllPistes() {
        return pisteService.retrieveAllPistes();
    }

    @GetMapping("/retrieve-piste/{numPiste}")
    public Piste retrievePiste(@PathVariable("numPiste") Long numPiste) {
        return pisteService.retrievePiste(numPiste);
    }

    @PostMapping("/add-piste")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @PutMapping("/update-piste")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }

    @DeleteMapping("/remove-piste/{numPiste}")
    public void removePiste(@PathVariable("numPiste") Long numPiste) {
        pisteService.removePiste(numPiste);
    }
}
