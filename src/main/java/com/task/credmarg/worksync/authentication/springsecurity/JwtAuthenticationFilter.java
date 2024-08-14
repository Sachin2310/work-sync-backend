package com.task.credmarg.worksync.authentication.springsecurity;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final UserDetailsServiceImplementation userDetailsService;
    private final JwtManager jwtManager;
    private final FilterErrorHandling filterErrorHandling;

    @Override
    @SneakyThrows
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        try {
            var accessToken = request.getHeader("Authorization");
            if (accessToken == null) {
                filterChain.doFilter(request, response);
                return;
            }
            var slicedToken = accessToken.substring(7);
            var userEmail = jwtManager.extractUserEmail(slicedToken);
            var userDetails = userDetailsService.loadUserByUsername(userEmail);
            if (jwtManager.isTokenValid(slicedToken)) {
                var authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, null);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            filterErrorHandling.setErrorResponse(e, response);
        }
    }
}
