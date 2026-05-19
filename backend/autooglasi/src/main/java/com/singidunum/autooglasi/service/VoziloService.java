package com.singidunum.autooglasi.service;

import com.singidunum.autooglasi.model.Vozilo;
import com.singidunum.autooglasi.repository.VoziloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoziloService {

    @Autowired
    private VoziloRepository voziloRepository;


    public Vozilo dodajVozilo(Vozilo vozilo) {
        return voziloRepository.save(vozilo);
    }


    public List<Vozilo> vratiSvaVozila() {
        return voziloRepository.findAll();
    }


    public Optional<Vozilo> vratiVoziloPoIdu(Long id) {
        return voziloRepository.findById(id);
    }


    public void obrisiVozilo(Long id) {
        voziloRepository.deleteById(id);
    }
}