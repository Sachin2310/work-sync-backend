package com.task.credmarg.worksync.authentication.springsecurity;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
@RequiredArgsConstructor
public class TokenAuthenticationController {
    private final JwtManager jwtManager;

    @PostMapping("/validate")
    public boolean validateToken(@RequestBody String token) {
        return jwtManager.isTokenValid(token);
    }

    @GetMapping("/generate")
    public String generateToken(@RequestHeader("User-Email") String userEmail) {
        return jwtManager.generateToken(userEmail);
    }
}
