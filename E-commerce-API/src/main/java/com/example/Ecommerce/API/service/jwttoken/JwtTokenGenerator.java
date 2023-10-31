package com.example.Ecommerce.API.service.jwttoken;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import io.jsonwebtoken.*;
import jakarta.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;


@Service
public class JwtTokenGenerator {

    @Value("${jwt.secret}")
    private String secretKey;

    public String generateJwtToken(String username){
        return Jwts.builder()
                .claim("username", username)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String generateJwtToken(Long id){
        return Jwts.builder()
                .claim("id", id)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Claims decodeJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    public Long extractIdFromHeader(HttpHeaders headers){
        String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwtToken = authorizationHeader.substring(7);
            Claims claims = decodeJWT(jwtToken);

            // Extract the id from the claims
            Number idNumber = (Number) claims.get("id");
            if (idNumber != null) {
                return idNumber.longValue();
            } else {
                throw new RuntimeException("ID not found in JWT claims");
            }
        }

        throw new RuntimeException("Invalid or missing Authorization header");
    }

    public String extractRoleFromHeader(HttpHeaders headers){
        String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwtToken = authorizationHeader.substring(7);
            Claims claims = decodeJWT(jwtToken);

            // Extract the id from the claims
            String role = (String) claims.get("role");
            if (role != null) {
                return role;
            } else {
                throw new RuntimeException("Role not found in JWT claims");
            }
        }

        throw new RuntimeException("Invalid or missing Authorization header");
    }
}
