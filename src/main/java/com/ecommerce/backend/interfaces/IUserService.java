package com.ecommerce.backend.interfaces;
import com.ecommerce.backend.controllers.auth.AuthenticateResponse;
import com.ecommerce.backend.controllers.auth.AuthenticationRequest;

public interface IUserService {
   AuthenticateResponse create(String firstName, String lastName, String email, String password);

    AuthenticateResponse authentication(AuthenticationRequest req);
}
