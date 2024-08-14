package com.task.credmarg.worksync.authentication.user.error;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler({
        AuthenticationException.class,
        SignatureException.class,
        ExpiredJwtException.class,
        JwtException.class
    })
    public ResponseEntity<ApiError> AuthenticationExceptionHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiError(401, "invalid_token", ex.getMessage()));
    }

    @ExceptionHandler({InternalAuthenticationServiceException.class})
    public ResponseEntity<ApiError> InternalAuthenticationServiceExceptionHandler(
            InternalAuthenticationServiceException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiError(403, "invalid_token", ex.getMessage()));
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ApiError> UserNotFoundExceptionExceptionHandler(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiError(404, "user_not_found", ex.getMessage()));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiError> CommonExceptionHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiError(500, "error", ex.getMessage()));
    }
}
