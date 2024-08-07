package com.task.credmarg.worksync.authentication.user;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserManagementService implements UserManagementService {
    Map<String, UserDetails> users = new HashMap<>();

    {
        users.put("admin", new UserDetails("admin", "admin"));
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        users.put(userDTO.userName(), mapUserDtoToUserDetails(userDTO));
        return userDTO;
    }

    private UserDetails mapUserDtoToUserDetails(UserDTO userDTO) {
        return new UserDetails(userDTO.userName(), userDTO.password());
    }

    @Override
    public boolean verifyUser(UserDTO userDTO) {
        if (!users.containsKey(userDTO.userName())) {
            return false;
        }
        return users.get(userDTO.userName()).password().equals(userDTO.password());
    }
}
