package com.singidunum.autooglasi.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Oglas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double cena;
    private String opis;
    private LocalDate datumPostavljanja;

    @ManyToOne
    @JoinColumn(name = "vozilo_id")
    private Vozilo vozilo;

    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDate getDatumPostavljanja() {
        return datumPostavljanja;
    }

    public void setDatumPostavljanja(LocalDate datumPostavljanja) {
        this.datumPostavljanja = datumPostavljanja;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}