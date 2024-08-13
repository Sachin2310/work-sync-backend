package com.task.credmarg.worksync.authentication.user.service;

import com.task.credmarg.worksync.authentication.user.User;
import com.task.credmarg.worksync.authentication.user.UserRepository;
import com.task.credmarg.worksync.authentication.user.controller.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class DefaultUserManagementService implements UserManagementService {
    private final UserRepository userRepository;
    private final UserInformationMapper userInformationMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignUpRequest addUser(SignUpRequest signUpRequest) {
        var userDetails = userInformationMapper.toUserDetails(signUpRequest);
        userRepository.save(userDetails);
        return signUpRequest;
    }

    @Override
    public boolean verifyUser(SignUpRequest signUpRequest) {
        var optionalUser = userRepository.findByEmail(signUpRequest.email());
        return optionalUser.map(user -> matchDetails(signUpRequest, user)).orElse(false);
    }

    @Override
    public boolean isValidUser(String userEmail) {
        return userRepository.findByEmail(userEmail).isPresent();
    }

    private boolean matchDetails(SignUpRequest toVerify, User realDetails) {
        return passwordEncoder.matches(toVerify.password(), realDetails.getPassword());
    }
}
