package com.lockgenius.passwordGenerator.controller;


import com.lockgenius.passwordGenerator.Dto.login;
import com.lockgenius.passwordGenerator.Utils.JWT;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JWT jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JWT jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody login loginDTO) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
        );

        String jwt = jwtUtil.generateToken(auth.getName());
        return ResponseEntity.ok(jwt);
    }
}
