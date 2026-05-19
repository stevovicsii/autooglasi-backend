package com.singidunum.autooglasi.repository;

import com.singidunum.autooglasi.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Optional<Korisnik> findByUsername(String username);
}