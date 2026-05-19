package com.singidunum.autooglasi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Vozilo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private int godiste;
    private int konjskaSnaga;

    @ManyToOne
    @JoinColumn(name = "brend_id")
    private Brend brend;

    @OneToMany(mappedBy = "vozilo", cascade = CascadeType.ALL)
    private List<Oglas> oglasi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public int getKonjskaSnaga() {
        return konjskaSnaga;
    }

    public void setKonjskaSnaga(int konjskaSnaga) {
        this.konjskaSnaga = konjskaSnaga;
    }

    public Brend getBrend() {
        return brend;
    }

    public void setBrend(Brend brend) {
        this.brend = brend;
    }

    public List<Oglas> getOglasi() {
        return oglasi;
    }

    public void setOglasi(List<Oglas> oglasi) {
        this.oglasi = oglasi;
    }
}