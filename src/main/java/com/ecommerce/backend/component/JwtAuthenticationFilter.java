package com.ecommerce.backend.component;

import com.ecommerce.backend.Exception.BaseException;
import com.ecommerce.backend.services.JwtService;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
@Log4j2
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            @Nonnull HttpServletRequest request,
            @Nonnull HttpServletResponse response,
            @Nonnull FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String xHeader = request.getHeader("x-header");


        if (isTokenMissingOrInvalid(authHeader)) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            final String jwt = extractJwtToken(authHeader);
            if (jwt == null || jwt.equals("null")){
                handleInvalidToken(request,response);
                return;
            }
            String userEmail = jwtService.extractUsername(jwt);
            if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
                handleValidToken(userEmail,jwt,request);
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error("EXCEPTION AUTHENTICATION {}", e.getMessage());
            resolver.resolveException(request, response, null, new BaseException(e.getMessage(), null));
        }
    }

    private boolean isTokenMissingOrInvalid(String authHeader){
        return authHeader == null || !authHeader.startsWith("Bearer ");
    }

    private String extractJwtToken(String authHeader){
        return authHeader.substring(7);
    }


    private void handleInvalidToken(HttpServletRequest request, HttpServletResponse response){
        resolver.resolveException(request,response,null,new BaseException("Token is Invalid"));
    }

    private void handleValidToken(String userEmail,String jwt,HttpServletRequest request){
        UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
        if(jwtService.isTokenValid(jwt,userDetails)){
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );

            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
    }
}
