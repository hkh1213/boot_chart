package com.chartprj.chart.security.jwt;

import com.chartprj.chart.security.service.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

import java.io.Serializable;
import java.util.Date;

@Component
public class JwtUtils implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    // 비밀키 선언
    @Value("${chart_user.app.jwtSecret}")
    private String jwtSecret;
    // 토큰 만료일
    @Value("${chart_user.app.jwtExpirationMs}")
    private int jwtExpirationMs;
    //토큰 생성 함수
    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("유효하지 않은 JWT 시그니처: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("유효하지 않은 JWT 토큰: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT 토큰 만료일: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT 토큰이 제공되지 않음: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT 클레임이 비어있음: {}", e.getMessage());
        }

        return false;
    }
}