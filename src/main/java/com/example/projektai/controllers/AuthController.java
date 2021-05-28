package com.example.projektai.controllers;

import com.example.projektai.dto.JwtAuthenticationResponse;
import com.example.projektai.dto.UserCredentials;
import com.example.projektai.entities.Role;
import com.example.projektai.entities.RoleName;
import com.example.projektai.entities.User;
import com.example.projektai.repositories.RoleRepository;
import com.example.projektai.repositories.UserRepository;
import com.example.projektai.services.JWTService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    //TODO: To też do serwisu
    private final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    //TODO: Obsłużenie w serwisie
    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody UserCredentials userCredentials){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userCredentials.getUsername(),
                        userCredentials.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();
        String accessToken = JWTService.generateToken(user);
        return ResponseEntity.ok(new JwtAuthenticationResponse(accessToken));
    }

    //TODO: Obsłużenie w serwisie
    @PostMapping("/registration")
    public ResponseEntity<String> register(@RequestBody UserCredentials userCredentials){
        if (userRepository.existsByUsername(userCredentials.getUsername())){
            return ResponseEntity.badRequest().body("Taki username jest już zajęty");
        }
        User user = new User(userCredentials.getUsername(),passwordEncoder.encode(userCredentials.getPassword()));
        Role role = roleRepository.findRoleByName(RoleName.ROLE_MODERATOR);
        user.grantRole(role);
        userRepository.save(user);
        return ResponseEntity.status(201).body("Użytkownik " + user.getUsername() + " Został zarejestrowany");
    }
}
