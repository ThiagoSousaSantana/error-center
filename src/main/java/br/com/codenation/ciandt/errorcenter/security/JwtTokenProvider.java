package br.com.codenation.ciandt.errorcenter.security;

import br.com.codenation.ciandt.errorcenter.models.Users;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private Long jwtTempoExpiracao;

    public String geraToken(Authentication authentication) {
        var user = (Users) authentication.getPrincipal();

        Date dataAtual = new Date();
        Date dataExpiracao = new Date(dataAtual.getTime() + jwtTempoExpiracao);

        return Jwts.builder()
                .setSubject(user.getId().toString())
                .setIssuedAt(dataAtual)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public UUID getIdUsuario(String token) {
        return UUID.fromString(Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token.substring(7))
                .getBody()
                .getSubject());
    }

    public Boolean validaToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token.substring(7));
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty." + ex.getMessage());
        }
        return false;
    }
}