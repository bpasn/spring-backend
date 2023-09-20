package com.firstApp.firstApp.interfaces;

import com.firstApp.firstApp.response.AuthenticateResponse;
import com.firstApp.firstApp.request.AuthenticationRequest;

public interface IUserService {
    AuthenticateResponse create(String firstName, String lastName, String email, String password);

    AuthenticateResponse authentication(AuthenticationRequest req);
}
