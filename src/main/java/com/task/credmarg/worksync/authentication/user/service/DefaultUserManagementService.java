package com.task.credmarg.worksync.authentication.user.service;

import com.task.credmarg.worksync.authentication.user.User;
import com.task.credmarg.worksync.authentication.user.UserRepository;
import com.task.credmarg.worksync.authentication.user.controller.CreateUserRequest;
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
    public CreateUserRequest addUser(CreateUserRequest createUserRequest) {
        var userDetails = userInformationMapper.toUserDetails(createUserRequest);
        userRepository.save(userDetails);
        return createUserRequest;
    }

    @Override
    public boolean verifyUser(CreateUserRequest createUserRequest) {
        var optionalUser = userRepository.findByEmail(createUserRequest.email());
        return optionalUser.map(user -> matchDetails(createUserRequest, user)).orElse(false);
    }

    @Override
    public boolean isValidUser(String userEmail) {
        return userRepository.findByEmail(userEmail).isPresent();
    }

    private boolean matchDetails(CreateUserRequest toVerify, User realDetails) {
        return passwordEncoder.matches(toVerify.password(), realDetails.getPassword());
    }
}
