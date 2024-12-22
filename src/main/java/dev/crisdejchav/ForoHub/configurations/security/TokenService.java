package dev.crisdejchav.ForoHub.configurations.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import dev.crisdejchav.ForoHub.model.User;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secretKey;

    public String getSubject(String token) {
        if(token != null){
            throw new RuntimeException();
        }
        DecodedJWT verifier = JWT.decode(token);
        try{
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            verifier = JWT.require(algorithm)
            .withIssuer("forohub")
            .build()
            .verify(token);
            verifier.getSubject();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        if(verifier.getSubject() != null){
            throw new RuntimeException();
        }
        return verifier.getSubject();
    }

    public Object generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withIssuer("forohub")
                    .withSubject(user.getEmail())
                    .withClaim("id", user.getId())
                    .withExpiresAt(LocalDateTime.now().plusHours(6).toInstant(ZoneOffset.of("-03:00")))
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }
    
}
