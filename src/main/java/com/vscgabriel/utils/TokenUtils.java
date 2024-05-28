package com.vscgabriel.utils;

import com.vscgabriel.application.dto.UserDTO;
import com.vscgabriel.domain.models.User;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;

import java.util.Collections;
import java.util.Set;

public class TokenUtils {


    public static String generateToken(UserDTO user) {
        long currentTimeInSecs = System.currentTimeMillis() / 1000 ;
        long expirationTime =  currentTimeInSecs + 3600 ;
        return Jwt.issuer("http://localhost:8080")
                .claim("id", user.getId())
                .claim("type", user.getRole())
                .issuedAt(currentTimeInSecs)
                .expiresAt(expirationTime)
                .sign();
    }
}