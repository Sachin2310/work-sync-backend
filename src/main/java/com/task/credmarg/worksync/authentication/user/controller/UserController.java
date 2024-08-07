package com.task.credmarg.worksync.authentication.user.controller;

import com.task.credmarg.worksync.authentication.user.service.UserManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserManagementService userManagementService;

    @PostMapping
    ResponseEntity<UserDTO> addUser(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok(userManagementService.addUser(userDTO));
    }

    @GetMapping
    ResponseEntity<Boolean> verifyUserDetails(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userManagementService.verifyUser(userDTO));
    }
}
