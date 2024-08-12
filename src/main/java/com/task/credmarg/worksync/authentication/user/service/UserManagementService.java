package com.task.credmarg.worksync.authentication.user.service;

import com.task.credmarg.worksync.authentication.user.controller.CreateUserRequest;

public interface UserManagementService {
    CreateUserRequest addUser(CreateUserRequest createUserRequest);

    boolean verifyUser(CreateUserRequest createUserRequest);

    boolean isValidUser(String userEmail);
}
