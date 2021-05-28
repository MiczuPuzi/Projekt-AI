package com.example.projektai.services;

import com.example.projektai.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.security.SignatureException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {
    private final static String SECRET = "alamadwakotyakubamapsa";

    public static String extractUsername(String token) throws SignatureException {
        return extractClaim(token, Claims::getSubject);
    }

    public static Date extractExpiration(String token) throws SignatureException {
        return extractClaim(token, Claims::getExpiration);
    }

    public static Date extractIssuedAt(String token) throws SignatureException {
        return extractClaim(token, Claims::getIssuedAt);
    }

    public static boolean isExpired(String token) throws SignatureException {
        return extractExpiration(token).before(new Date());
    }

    public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) throws SignatureException {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private static Claims extractAllClaims(String token) throws SignatureException {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    public static String generateToken(User user) {
        return createToken(new HashMap<>(), user.getUsername());
    }

    public static boolean validateToken(String token, User user) throws SignatureException {
        return extractUsername(token).equals(user.getUsername()) && !isExpired(token);
    }

    private static String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

}
