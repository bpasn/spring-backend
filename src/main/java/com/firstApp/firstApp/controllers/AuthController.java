package com.firstApp.firstApp.controllers;

import com.firstApp.firstApp.response.AuthenticateResponse;
import com.firstApp.firstApp.request.AuthenticationRequest;
import com.firstApp.firstApp.request.UserRequest;
import com.firstApp.firstApp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticateResponse> create( @RequestBody @Valid UserRequest req)
    {

        return ResponseEntity.ok(userService.create(req.getFirstName(), req.getLastName(),req.getEmail(),req.getPassword()));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticateResponse> authentication(@RequestBody @Valid AuthenticationRequest req){
        return ResponseEntity.ok(userService.authentication(req));
    }
}
