package com.task.credmarg.worksync.authentication.user.service;

import com.task.credmarg.worksync.authentication.user.controller.UserDTO;

public interface UserManagementService {
    UserDTO addUser(UserDTO userDTO);

    boolean verifyUser(UserDTO userDTO);
}
