package com.ecommerce.backend.services;

import com.ecommerce.backend.Exception.BaseException;
import com.ecommerce.backend.controllers.auth.AuthenticateResponse;
import com.ecommerce.backend.controllers.auth.AuthenticationRequest;
import com.ecommerce.backend.entity.Users;
import com.ecommerce.backend.enums.Role;
import com.ecommerce.backend.interfaces.IUserService;
import com.ecommerce.backend.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthenticateResponse create(String firstName, String lastName, String email, String password) {

        boolean existingEmail = userRepository.existsByEmail(email);
        if (existingEmail){
            throw new BaseException("Email already exists",HttpStatus.CONFLICT);
        }
            
        Users users = new Users();
        users.setEmail(email);
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setPassword(passwordEncoder.encode(password));
        users.setRoles(Role.USER);
        Users user = userRepository.save(users);
        String token = jwtService.generateToken(user);
        return AuthenticateResponse.builder().token(token).build();
    }

    @Override
    public AuthenticateResponse authentication(AuthenticationRequest req) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(),
                        req.getPassword()));
        Users user = userRepository.findByEmail(req.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);

        return AuthenticateResponse.builder().token(jwtToken).build();
    }
}
