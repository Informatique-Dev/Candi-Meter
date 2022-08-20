package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
@Component
@Log4j2
public class TokenProvider {

    @Value("${app.jwt.token.expiration-in-ms}")
    private Long tokenExpirationMillis;

    @Value("${app.jwt.refresh.expiration-in-ms}")
    private Long refreshTokenExpirationMillis;

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String subject,TokenType tokenType) {

        Long expireTime =(tokenType == TokenType.ACCESS_TOKEN) ? tokenExpirationMillis : refreshTokenExpirationMillis;


        Date now = new Date();
        long duration = now.getTime() + expireTime;
        Date expiryDate = new Date(duration);



        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public LocalDateTime getExpiryDateFromToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        return LocalDateTime.ofInstant(claims.getExpiration().toInstant(), ZoneId.systemDefault());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            log.error("JWT expired: {}", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            log.error("Token is null, empty or only whitespace: {}", ex.getMessage());
        } catch (MalformedJwtException ex) {
            log.error("JWT is invalid: {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            log.error("JWT is not supported: {}", ex.getMessage());
        }

        return false;


    }


}
