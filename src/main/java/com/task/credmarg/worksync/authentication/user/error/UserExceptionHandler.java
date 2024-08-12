package com.task.credmarg.worksync.authentication.user.error;

import io.jsonwebtoken.JwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler({JwtException.class})
    public ResponseEntity<ApiError> JwtExceptionHandler(JwtException ex) {
        return null;
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<ApiError> AuthenticationExceptionHandler(AuthenticationException ex) {
        return null;
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ApiError> UserNotFoundExceptionExceptionHandler(UserNotFoundException ex) {
        return null;
    }

    // InternalAuthenticationServiceException, SignatureException
}
