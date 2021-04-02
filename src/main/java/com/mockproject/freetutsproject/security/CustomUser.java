package com.mockproject.freetutsproject.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
public class CustomUser extends User {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String fullname;

    public CustomUser( Long id, String fullname, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        this.fullname = fullname;
    }
}
