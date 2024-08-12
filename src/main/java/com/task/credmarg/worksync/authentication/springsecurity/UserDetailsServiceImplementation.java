package com.task.credmarg.worksync.authentication.springsecurity;

import com.task.credmarg.worksync.authentication.user.UserRepository;
import com.task.credmarg.worksync.authentication.user.error.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var userDetails = userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + username));
        return User.builder()
                .username(userDetails.getEmail())
                .password(userDetails.getPassword())
                .build();
    }
}
