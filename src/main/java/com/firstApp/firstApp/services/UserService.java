package com.firstApp.firstApp.services;

import com.firstApp.firstApp.Exception.BaseException;
import com.firstApp.firstApp.controllers.auth.AuthenticateResponse;
import com.firstApp.firstApp.controllers.auth.AuthenticationRequest;
import com.firstApp.firstApp.entity.UserEntity;
import com.firstApp.firstApp.enums.Role;
import com.firstApp.firstApp.interfaces.IUserService;
import com.firstApp.firstApp.mapper.UserMapper;
import com.firstApp.firstApp.repository.UserRepository;

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
    private final UserMapper mapper;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       UserMapper mapper, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
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
            
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userEntity.setPassword(passwordEncoder.encode(password));
        userEntity.setRoles(Role.USER);
mapper.userEntityToModel(userEntity);
        UserEntity user = userRepository.save(userEntity);
        String token = jwtService.generateToken(user);
        return AuthenticateResponse.builder().token(token).build();
    }

    @Override
    public AuthenticateResponse authentication(AuthenticationRequest req) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(),
                        req.getPassword()));
        UserEntity user = userRepository.findByEmail(req.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);

        return AuthenticateResponse.builder().token(jwtToken).build();
    }
}
