package com.towhid.practicepharmacy.jwt;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    // Resolve token from the Authorization header
    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Remove "Bearer " prefix
        }
        return null;
    }

    // Validate the JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey.getBytes()) // Ensure the secret is properly encoded
                    .build()
                    .parseClaimsJws(token); // Parse and validate the token
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false; // Invalid token
        }
    }

    // Get the username from the token
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes()) // Ensure the secret is properly encoded
                .build()
                .parseClaimsJws(token) // Parse the token
                .getBody()
                .getSubject(); // Retrieve the subject (username)
    }
}