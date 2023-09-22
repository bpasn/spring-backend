package com.firstApp.firstApp.controllers.authenticate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticateResponse {
    private String token;
}
