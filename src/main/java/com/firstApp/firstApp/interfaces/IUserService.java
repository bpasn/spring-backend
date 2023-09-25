package com.firstApp.firstApp.interfaces;
import com.firstApp.firstApp.controllers.auth.AuthenticateResponse;
import com.firstApp.firstApp.controllers.auth.AuthenticationRequest;

public interface IUserService {
   AuthenticateResponse create(String firstName, String lastName, String email, String password);

    AuthenticateResponse authentication(AuthenticationRequest req);
}
