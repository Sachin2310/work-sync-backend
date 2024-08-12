package com.task.credmarg.worksync.authentication.user.service;

import com.task.credmarg.worksync.authentication.user.User;
import com.task.credmarg.worksync.authentication.user.controller.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserInformationMapper {
    private final PasswordEncoder passwordEncoder;

    public User toUserDetails(CreateUserRequest createUserRequest) {
        return User.builder()
                .userName(createUserRequest.userName())
                .email(createUserRequest.email())
                .password(passwordEncoder.encode(createUserRequest.password()))
                .build();
    }
}
