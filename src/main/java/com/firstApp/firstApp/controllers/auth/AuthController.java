package com.firstApp.firstApp.controllers.auth;

import com.firstApp.firstApp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
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
        return ResponseEntity.ok(userService.authentication(request));

    }
}
