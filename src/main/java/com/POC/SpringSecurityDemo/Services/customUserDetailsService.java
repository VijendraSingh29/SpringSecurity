package com.POC.SpringSecurityDemo.Services;

import com.POC.SpringSecurityDemo.Models.User;
import com.POC.SpringSecurityDemo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class customUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository ;
    @Override
    public UserDetails loadUserByUsername(String username) {

        User user = userRepository.findByUserName(username);

        if(user == null)
        {
            throw new UsernameNotFoundException("User is not registered") ;
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
     //   return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("Not found in Systme"));
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                authorities
        );
    }
}
