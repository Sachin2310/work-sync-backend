package com.task.credmarg.worksync.authentication.user.service;

import com.task.credmarg.worksync.authentication.user.User;
import com.task.credmarg.worksync.authentication.user.controller.SignUpRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InMemoryUserManagementService implements UserManagementService {
    private final UserInformationMapper userInformationMapper;
    Map<String, User> users = new HashMap<>();

    {
        users.put("admin", new User(100, "admin", "admin", "admin", null));
    }

    @Override
    public SignUpRequest addUser(SignUpRequest signUpRequest) {
        var userDetails = userInformationMapper.toUserDetails(signUpRequest);
        users.put(signUpRequest.email(), userDetails);
        return signUpRequest;
    }

    @Override
    public boolean verifyUser(SignUpRequest signUpRequest) {
        return users.keySet().stream()
                .filter(email -> email.equals(signUpRequest.email()))
                .map((email) -> matchUserDetails(email, signUpRequest))
                .findFirst()
                .orElse(false);
    }

    private boolean matchUserDetails(String email, SignUpRequest signUpRequest) {
        return users.get(email).getPassword().equals(signUpRequest.password());
    }

    @Override
    public boolean isValidUser(String userEmail) {
        return Optional.ofNullable(users.get(userEmail)).isPresent();
    }
}
