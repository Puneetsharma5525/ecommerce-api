package com.ecommerce.shopping.ecommerceuserpannelapi.config;

import com.ecommerce.shopping.ecommerceuserpannelapi.utils.JWTUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Fetch token from request
        var jwtTokenOptional = getTokenFromRequest(request);

        // Validate jwt token -> JWT utils
        jwtTokenOptional.ifPresent(jwtToken -> {
            if (JWTUtils.validateToken(jwtToken)) {
                // Get user from JWT token
                var userNameOptional = JWTUtils.getUsernameFromToken(jwtToken);
                userNameOptional.ifPresent(userName-> {
                    // Fetch user Details with the help of userName
                    var userDetails = userDetailsService.loadUserByUsername(userName);
                    // Crate  Authentication Token
                    var authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // Set authentication  token to Security Context
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                });
            }
        });

        // pass request and response to next filter
        filterChain.doFilter(request, response);
    }

    public Optional<String> getTokenFromRequest(HttpServletRequest request) {
        // Extract authentication header
        var authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        // Bearer <JWT Token>
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return Optional.of(authHeader.substring(7));
        }
        return Optional.empty();
    }
}
