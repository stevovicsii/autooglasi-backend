package com.singidunum.autooglasi.controller;

import com.singidunum.autooglasi.dto.LoginRequest;
import com.singidunum.autooglasi.model.Korisnik;
import com.singidunum.autooglasi.repository.KorisnikRepository;
import com.singidunum.autooglasi.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public String register(@RequestBody Korisnik korisnik) {

        korisnik.setPassword(passwordEncoder.encode(korisnik.getPassword()));
        korisnikRepository.save(korisnik);
        return "Korisnik uspesno registrovan!";
    }


    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String accessToken = jwtUtil.generisiToken(request.getUsername());
        String refreshToken = jwtUtil.generisiRefreshToken(request.getUsername());

        Map<String, String> tokeni = new HashMap<>();
        tokeni.put("accessToken", accessToken);
        tokeni.put("refreshToken", refreshToken);

        return tokeni;
    }


    @PostMapping("/refresh")
    public Map<String, String> refresh(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refreshToken");
        String username = jwtUtil.izvuciKorisnickoIme(refreshToken);

        if (jwtUtil.daLiJeTokenValidan(refreshToken, username)) {
            String noviAccessToken = jwtUtil.generisiToken(username);
            Map<String, String> tokeni = new HashMap<>();
            tokeni.put("accessToken", noviAccessToken);
            return tokeni;
        } else {
            throw new RuntimeException("Refresh token nije validan!");
        }
    }
}