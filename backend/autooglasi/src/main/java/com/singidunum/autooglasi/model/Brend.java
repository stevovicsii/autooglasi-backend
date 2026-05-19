package com.singidunum.autooglasi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Brend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    @OneToMany(mappedBy = "brend", cascade = CascadeType.ALL)
    private List<Vozilo> vozila;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Vozilo> getVozila() {
        return vozila;
    }

    public void setVozila(List<Vozilo> vozila) {
        this.vozila = vozila;
    }
}