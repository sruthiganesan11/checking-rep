package com.guvi.hospitalManagementSystem.security;

import com.guvi.hospitalManagementSystem.entity.User;
import com.guvi.hospitalManagementSystem.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {
    @Autowired
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (isValidUser(username, password)) {
            return new UsernamePasswordAuthenticationToken(username, password);
        } else {
            throw new AuthenticationException("Invalid Credentials") {
            };
        }
    }

    //Check a user is a valid user
    private boolean isValidUser(String username, String password) {
        User user = userRepo.findByUsernameOrEmail(username, password)
                .orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
        return passwordEncoder.matches(password, user.getPassword());
    }
}
