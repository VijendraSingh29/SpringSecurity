//package com.POC.SpringSecurityDemo.Services;
//
//import com.POC.SpringSecurityDemo.Models.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.HashSet;
//
//@Service
//public class CustomUserDetails implements UserDetails {
//
//    User user ;
//    public CustomUserDetails(User user) {
//        this.user = user ;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        HashSet<GrantedAuthority> set = new HashSet<>() ;
//
//        set.add(new SimpleGrantedAuthority(this.user.getRole()));
//
//        return set ;
//
//    }
//
//    @Override
//    public String getPassword() {
//        return this.user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return this.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true ;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true ;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true ;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
