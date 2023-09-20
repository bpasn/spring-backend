package com.firstApp.firstApp.models;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserModel {
    private String firstName;
    private String lastName;
    private String email;
}
