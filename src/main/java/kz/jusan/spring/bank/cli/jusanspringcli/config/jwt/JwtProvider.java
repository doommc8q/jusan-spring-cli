package kz.jusan.spring.bank.cli.jusanspringcli.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expired}")
    private Long expTime;

    public String generateToken(Users user, String role) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("role", role);
        claims.put("id", user.getUserId());
        Date now = new Date();
        Date validity = new Date(now.getTime() + expTime * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
