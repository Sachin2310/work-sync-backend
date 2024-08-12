package com.task.credmarg.worksync.authentication.user.controller;

import com.task.credmarg.worksync.authentication.springsecurity.JwtManager;
import com.task.credmarg.worksync.authentication.user.service.UserManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserAuthenticationController {
    private final UserManagementService userManagementService;
    private final AuthenticationManager authenticationManager;
    private final JwtManager jwtManager;

    @PostMapping("/signup")
    ResponseEntity<CreateUserRequest> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userManagementService.addUser(createUserRequest));
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponse> verifyUser(@RequestBody LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
        var token = jwtManager.generateToken(loginRequest.email());
        return ResponseEntity.ok(new LoginResponse(loginRequest.email(), token));
    }
}
