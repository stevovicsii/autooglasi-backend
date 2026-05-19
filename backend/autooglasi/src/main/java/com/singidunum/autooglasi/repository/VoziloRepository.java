package com.singidunum.autooglasi.repository;

import com.singidunum.autooglasi.model.Vozilo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoziloRepository extends JpaRepository<Vozilo, Long> {
}