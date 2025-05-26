package com.monqui.van_go.config;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.monqui.van_go.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    
    @Value("${security.jwt.expiration}")
    private String expiration;
    
    @Value("${security.jwt.signing-key}")
    private String signingKey;
    
    public String generateToken(User user) {
        long expirationMinutes = Long.valueOf(expiration);
        LocalDateTime expirationDateTime = LocalDateTime.now().plusMinutes(expirationMinutes);
        Date expirationDate = Date.from(expirationDateTime.atZone(ZoneId.systemDefault()).toInstant());
        
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("email", user.getEmail());
        claims.put("typeEntity", user.getTypeEntity());
        
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    
    public Claims parseClaims(String token) throws ExpiredJwtException {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(signingKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public boolean validateToken(String token) {
        try {
            Claims claims = parseClaims(token);
            Date expirationDate = claims.getExpiration();
            LocalDateTime expiration = expirationDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            return !LocalDateTime.now().isAfter(expiration);
        } catch (Exception ex) {
            return false;
        }
    }
    
    public String getUserEmail(String token) throws ExpiredJwtException {
        Claims claims = parseClaims(token);
        return claims.get("email", String.class);
    }
    
    public Long getUserId(String token) throws ExpiredJwtException {
        Claims claims = parseClaims(token);
        return claims.get("id", Long.class);
    }
    
    public String getUserName(String token) throws ExpiredJwtException {
        Claims claims = parseClaims(token);
        return claims.get("name", String.class);
    }
}