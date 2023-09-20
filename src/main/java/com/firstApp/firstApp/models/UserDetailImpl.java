package com.firstApp.firstApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firstApp.firstApp.entity.UserEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class UserDetailImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;

    private String email;

    @JsonIgnore
    private String password;

    public UserDetailImpl(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    private Collection<? extends GrantedAuthority> authorities;


    public static UserDetailImpl build(UserEntity user){

        return new UserDetailImpl(user.getFirstName(), user.getLastName(), user.getEmail(),user.getPassword());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
