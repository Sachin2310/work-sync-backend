package com.task.credmarg.worksync.authentication.user;

import com.task.credmarg.worksync.authentication.user.controller.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserInformationMapper {
    public UserDetails toUserDetails(UserDTO userDTO) {
        return UserDetails.builder()
                .userName(userDTO.getUserName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
    }
}
