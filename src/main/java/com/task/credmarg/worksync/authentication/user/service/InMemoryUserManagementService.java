package com.task.credmarg.worksync.authentication.user.service;

import com.task.credmarg.worksync.authentication.user.UserDetails;
import com.task.credmarg.worksync.authentication.user.controller.UserDTO;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class InMemoryUserManagementService implements UserManagementService {
    Map<String, UserDetails> users = new HashMap<>();

    {
        users.put("admin", new UserDetails(100, "admin", "admin", "admin"));
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        users.put(userDTO.getEmail(), mapUserDtoToUserDetails(userDTO));
        return userDTO;
    }

    private UserDetails mapUserDtoToUserDetails(UserDTO userDTO) {
        return new UserDetails(userDTO.getId(), userDTO.getUserName(), userDTO.getEmail(), userDTO.getPassword());
    }

    @Override
    public boolean verifyUser(UserDTO userDTO) {
        if (!users.containsKey(userDTO.getEmail())) {
            return false;
        }
        return users.get(userDTO.getEmail()).getUserName().equals(userDTO.getUserName())
                && users.get(userDTO.getEmail()).getPassword().equals(userDTO.getPassword());
    }
}
