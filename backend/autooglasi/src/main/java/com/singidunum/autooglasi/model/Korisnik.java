package com.singidunum.autooglasi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "korisnik_uloga",
            joinColumns = @JoinColumn(name = "korisnik_id"),
            inverseJoinColumns = @JoinColumn(name = "uloga_id")
    )
    private List<Uloga> uloge;

    @OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL)
    private List<Oglas> oglasi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Uloga> getUloge() {
        return uloge;
    }

    public void setUloge(List<Uloga> uloge) {
        this.uloge = uloge;
    }

    public List<Oglas> getOglasi() {
        return oglasi;
    }

    public void setOglasi(List<Oglas> oglasi) {
        this.oglasi = oglasi;
    }
}