package com.singidunum.autooglasi.service;

import com.singidunum.autooglasi.model.Korisnik;
import com.singidunum.autooglasi.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Korisnik korisnik = korisnikRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Korisnik nije pronadjen"));

        return new User(korisnik.getUsername(), korisnik.getPassword(),
                korisnik.getUloge().stream()
                        .map(uloga -> new SimpleGrantedAuthority(uloga.getNaziv()))
                        .collect(Collectors.toList()));
    }
}