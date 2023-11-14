package com.app.hospital_management_system.service.security;

import com.app.hospital_management_system.model.Users;
import com.app.hospital_management_system.model.principal.CustomUserPrincipal;
import com.app.hospital_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = ur.findByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException(username);
        }

        return new CustomUserPrincipal(user);
    }
}
