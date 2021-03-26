package com.mockproject.freetutsproject.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
public class CustomUser extends User {
    private Long id;
    private String fullname;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id, String fullname) {
        super(username, password, authorities);
        this.id = id;
        this.fullname = fullname;
    }
}
