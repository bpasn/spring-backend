package com.firstApp.firstApp.interfaces;

import com.firstApp.firstApp.controllers.authenticate.AuthenticateResponse;
import com.firstApp.firstApp.controllers.authenticate.AuthenticateRequest;

public interface IUserService {
    AuthenticateResponse create(String firstName, String lastName, String email, String password);

    AuthenticateResponse authentication(AuthenticateRequest req);
}
