package com.task.credmarg.worksync.authentication.user.service;

import com.task.credmarg.worksync.authentication.user.User;
import com.task.credmarg.worksync.authentication.user.controller.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserInformationMapper {
    private final PasswordEncoder passwordEncoder;

    public User toUserDetails(SignUpRequest signUpRequest) {
        return User.builder()
                .userName(signUpRequest.name())
                .email(signUpRequest.email())
                .password(passwordEncoder.encode(signUpRequest.password()))
                .build();
    }
}
