package com.ecommerce.backend.controllers.auth;

import com.ecommerce.backend.services.UserService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Log4j2
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticateResponse> register(@Valid @RequestBody ReqUserRegister  request){
        return ResponseEntity.ok(userService.create(request.getFirstName(),request.getLastName(), request.getEmail(), request.getPassword()));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticateResponse> authentication(@Valid @RequestBody AuthenticationRequest request){
        log.info(request.getEmail());
        log.info(request.getPassword());
        return ResponseEntity.ok(userService.authentication(request));

    }
}
