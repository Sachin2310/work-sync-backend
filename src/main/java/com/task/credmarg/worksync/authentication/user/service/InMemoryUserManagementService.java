// package com.task.credmarg.worksync.authentication.user.service;
//
// import com.task.credmarg.worksync.authentication.user.User;
// import com.task.credmarg.worksync.authentication.user.controller.UserDTO;
// import java.util.HashMap;
// import java.util.Map;
// import org.springframework.stereotype.Service;
//
// @Service
// public class InMemoryUserManagementService implements UserManagementService {
//    Map<String, User> users = new HashMap<>();
//
//    {
//        users.put("admin", new User(100, "admin", "admin", "admin", null));
//    }
//
//    @Override
//    public UserDTO addUser(UserDTO userDTO) {
//        users.put(userDTO.getEmail(), mapUserDtoToUserDetails(userDTO));
//        return userDTO;
//    }
//
//    private User mapUserDtoToUserDetails(UserDTO userDTO) {
//        return User.builder()
//                .userName(userDTO.getUserName())
//                .email(userDTO.getEmail())
//                .password(userDTO.getPassword())
//                .build();
//    }
//
//    @Override
//    public boolean verifyUser(UserDTO userDTO) {
//        if (!users.containsKey(userDTO.getEmail())) {
//            return false;
//        }
//        return users.get(userDTO.getEmail()).getUserName().equals(userDTO.getUserName())
//                && users.get(userDTO.getEmail()).getPassword().equals(userDTO.getPassword());
//    }
// }
