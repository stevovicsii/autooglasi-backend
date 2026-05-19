package com.singidunum.autooglasi.repository;

import com.singidunum.autooglasi.model.Oglas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OglasRepository extends JpaRepository<Oglas, Long> {
}