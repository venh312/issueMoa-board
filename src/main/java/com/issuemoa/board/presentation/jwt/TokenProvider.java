package com.issuemoa.board.presentation.jwt;

import com.issuemoa.board.domain.exception.UsersNotFoundException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class TokenProvider {
    private final JwtProperties jwtProperties;

    public Claims getClaims(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(jwtProperties.getSecretKey())
                    .build()
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();
        }  catch (SignatureException e) {
            throw new UsersNotFoundException("Invalid token");
        }
    }

    public Long getUserId(String token) {
        Claims claims = getClaims(token);
        return ((Number) claims.get("userId")).longValue();
    }
}