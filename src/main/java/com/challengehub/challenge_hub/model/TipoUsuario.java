package com.challengehub.challenge_hub.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public enum TipoUsuario implements GrantedAuthority {
    COMUM,
    MODERADOR,
    ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(this);
    }
}
