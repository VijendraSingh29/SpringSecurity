/*
package com.POC.SpringSecurityDemo.Services;

import com.POC.SpringSecurityDemo.Models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private String userName ;

    private String role ;

    private String password;
    public CustomUserDetails(User user) {
        this.userName = user.getUserName() ;
        this.password = user.getPassword();
        this.role = user.getRole();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>() ;
        list.add(new SimpleGrantedAuthority(this.role));
        return list ;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true ;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true ;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true ;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
*/
