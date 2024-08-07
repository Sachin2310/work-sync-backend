package com.task.credmarg.worksync.authentication.user.service;

import com.task.credmarg.worksync.authentication.user.UserDetails;
import com.task.credmarg.worksync.authentication.user.UserInformationMapper;
import com.task.credmarg.worksync.authentication.user.UserRepository;
import com.task.credmarg.worksync.authentication.user.controller.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class DefaultUserManagementService implements UserManagementService {
    private final UserRepository userRepository;
    private final UserInformationMapper userInformationMapper;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        var userDetails = userInformationMapper.toUserDetails(userDTO);
        var savedUser = userRepository.save(userDetails);
        userDTO.setId(savedUser.getId());
        return userDTO;
    }

    @Override
    public boolean verifyUser(UserDTO userDTO) {
        var optionalUser = userRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
        return optionalUser
                .map(userDetails -> matchDetails(userDTO, userDetails))
                .orElse(false);
    }

    private boolean matchDetails(UserDTO toVerify, UserDetails realDetails) {
        return toVerify.getUserName().equals(realDetails.getUserName());
    }
}
