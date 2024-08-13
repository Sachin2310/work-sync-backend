package com.task.credmarg.worksync.authentication.springsecurity;

import com.task.credmarg.worksync.authentication.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtManager {
    private static final long TOKEN_LIFE_TIME = 30;
    private static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();

    public String generateToken(String userEmail) {
        var now = Instant.now();
        return Jwts.builder()
                .subject(userEmail)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(TOKEN_LIFE_TIME, ChronoUnit.MINUTES)))
                .signWith(SECRET_KEY)
                .compact();
    }

    // We have saved user email as username in UserDetails (implementation given by spring security)
    public boolean validateToken(String token, UserDetails userDetails) {
        var claims = getTokenPayload(token);
        var userEmail = claims.get("email", String.class);
        return userEmail.equals(userDetails.getUsername()) && isTokenExpired(claims);
    }

    public String extractUserEmail(String token) {
        var claims = getTokenPayload(token);
        System.out.println("claims: " + claims);
        return claims.getSubject();
    }

    private boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().toInstant().isBefore(Instant.now());
    }

    public boolean isTokenValid(String token) {
        return getTokenPayload(token).getExpiration().toInstant().isAfter(Instant.now());
    }

    private Claims getTokenPayload(String token) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // No usage for now
    private Map<String, String> createClaimsFromUserDetails(User userDetails) {
        return Map.of("email", userDetails.getEmail(), "name", userDetails.getUserName());
    }
}
