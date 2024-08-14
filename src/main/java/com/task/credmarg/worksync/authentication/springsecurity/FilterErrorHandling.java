package com.task.credmarg.worksync.authentication.springsecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.credmarg.worksync.authentication.user.error.ApiError;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilterErrorHandling {
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void setErrorResponse(Exception ex, HttpServletResponse response) {
        switch (ex.getClass().getSimpleName()) {
            case "AuthenticationException", "SignatureException", "ExpiredJwtException", "JwtException" -> {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter()
                        .write(objectMapper.writeValueAsString(new ApiError(401, "invalid_token", ex.getMessage())));
            }
            case "InternalAuthenticationServiceException" -> {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter()
                        .write(objectMapper.writeValueAsString(new ApiError(403, "invalid_token", ex.getMessage())));
            }
            case "UserNotFoundException" -> {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter()
                        .write(objectMapper.writeValueAsString(new ApiError(404, "user_not_found", ex.getMessage())));
            }
            default -> {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter()
                        .write(objectMapper.writeValueAsString(new ApiError(500, "error", ex.getMessage())));
            }
        }
    }
}
