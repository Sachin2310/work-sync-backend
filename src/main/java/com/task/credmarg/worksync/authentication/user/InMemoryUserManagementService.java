package com.task.credmarg.worksync.authentication.user;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class InMemoryUserManagementService implements UserManagementService {
    Map<String, UserDetails> users = new HashMap<>();

    {
        users.put("admin", new UserDetails("admin", "admin", "admin"));
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        users.put(userDTO.email(), mapUserDtoToUserDetails(userDTO));
        return userDTO;
    }

    private UserDetails mapUserDtoToUserDetails(UserDTO userDTO) {
        return new UserDetails(userDTO.userName(), userDTO.email(), userDTO.password());
    }

    @Override
    public boolean verifyUser(UserDTO userDTO) {
        if (!users.containsKey(userDTO.email())) {
            return false;
        }
        return users.get(userDTO.email()).userName().equals(userDTO.userName())
                && users.get(userDTO.email()).password().equals(userDTO.password());
    }
}
