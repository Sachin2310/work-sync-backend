package com.task.credmarg.worksync.authentication.user;

public interface UserManagementService {
    UserDTO addUser(UserDTO userDTO);

    boolean verifyUser(UserDTO userDTO);
}
