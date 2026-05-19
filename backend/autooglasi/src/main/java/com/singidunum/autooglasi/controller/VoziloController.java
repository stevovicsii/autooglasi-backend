package com.singidunum.autooglasi.controller;

import com.singidunum.autooglasi.model.Vozilo;
import com.singidunum.autooglasi.service.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vozila")
public class VoziloController {

    @Autowired
    private VoziloService voziloService;


    @PostMapping
    public Vozilo dodajVozilo(@RequestBody Vozilo vozilo) {
        return voziloService.dodajVozilo(vozilo);
    }


    @GetMapping
    public List<Vozilo> svaVozila() {
        return voziloService.vratiSvaVozila();
    }


    @GetMapping("/{id}")
    public Optional<Vozilo> jednoVozilo(@PathVariable Long id) {
        return voziloService.vratiVoziloPoIdu(id);
    }


    @PutMapping("/{id}")
    public Vozilo izmeniVozilo(@PathVariable Long id, @RequestBody Vozilo novoVozilo) {
        novoVozilo.setId(id);
        return voziloService.dodajVozilo(novoVozilo);
    }


    @DeleteMapping("/{id}")
    public void obrisiVozilo(@PathVariable Long id) {
        voziloService.obrisiVozilo(id);
    }
}