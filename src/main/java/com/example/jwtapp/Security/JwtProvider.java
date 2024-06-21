package com.example.jwtapp.Security;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtProvider {

    private Integer expireData =  12;
    private String secretKey = "appinit";
 
    public  String generateToken(String Subject){
        return Jwts
        .builder()
        .setSubject(Subject)
        .setIssuedAt(new Date())
        .setExpiration(new Date(LocalTime.now().plusHours(expireData).getHour()))
        .signWith(SignatureAlgorithm.HS512,secretKey )
        .compact();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser()
                   .setSigningKey(secretKey)
                   .parseClaimsJws(token);
                    return true;  
        } catch (Exception e) {
            System.out.println("xato ketyapdi        "+e.getMessage());
            return false;
        }
         
    }

    public String getSubject(String token){
            return Jwts
                   .parser()
                   .setSigningKey(secretKey)
                   .parseClaimsJws(token)
                   .getBody()
                   .getSubject();
        
      
         
    }
}
