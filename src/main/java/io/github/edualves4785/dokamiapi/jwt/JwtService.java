package io.github.edualves4785.dokamiapi.jwt;

import io.github.edualves4785.dokamiapi.domain.entities.AccessToken;
import io.github.edualves4785.dokamiapi.domain.entities.Usuario;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final SecretKeyGenerator keyGenerator;

    public AccessToken gerarToken(Usuario usuario) {

        SecretKey key = keyGenerator.getKey();
        Date dataExpiracao = gerarDataExpiracao();
        var claims = gerarTokenClaims(usuario);

        String token = Jwts
                .builder()
                .signWith(key)
                .subject(usuario.getEmail())
                .expiration(dataExpiracao)
                .claims(claims)
                .compact();

        return new AccessToken(token);
    }

    private Date gerarDataExpiracao() {
        var minutosExpiracao = 60;
        LocalDateTime agora = LocalDateTime.now().plusMinutes(minutosExpiracao);
        return Date.from(agora.atZone(ZoneId.systemDefault()).toInstant());
    }

    private Map<String, Object> gerarTokenClaims(Usuario usuario) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("nome", usuario.getNome());
        return claims;
    }

    public String getEmailFromToken(String tokenJwt) {
        try {
            JwtParser build = Jwts.parser()
                    .verifyWith(keyGenerator.getKey())
                    .build();

            Jws<Claims> claimsJws = build.parseSignedClaims(tokenJwt);

            Claims cls = claimsJws.getPayload();

            return cls.getSubject();
        } catch (JwtException e) {
            throw new InvalidTokenExcpetion(e.getMessage());
        }


    }
}
