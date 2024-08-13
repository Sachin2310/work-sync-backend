package com.task.credmarg.worksync.authentication.user.service;

import com.task.credmarg.worksync.authentication.user.controller.SignUpRequest;

public interface UserManagementService {
    SignUpRequest addUser(SignUpRequest signUpRequest);

    boolean verifyUser(SignUpRequest signUpRequest);

    boolean isValidUser(String userEmail);
}
