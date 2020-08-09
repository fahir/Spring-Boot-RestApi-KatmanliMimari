package com.springproject.demo.auth;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;


@Service
public class TokenManager {
    private static  final int expTime=5*60*1000;
    Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String userName){

       return  Jwts.builder()
               .setSubject(userName)
               .setExpiration(new Date(System.currentTimeMillis()+expTime))
               .setIssuer("fahirÖZBAY")
               .setIssuedAt(new Date(System.currentTimeMillis()))
               .signWith( secretKey)
               .compact();

   }

 public boolean   tokenValidate(String token){
       var result=getClaims(token);
       if(result.getSubject()!=null &&result.getExpiration().after(
               new Date(System.currentTimeMillis())))
       {
           return true;
 }
       return  false;
}
  public Claims  getClaims(String token){



          return  Jwts.parserBuilder()
                  .setSigningKey(secretKey)
                  .build()
                  .parseClaimsJws(token).getBody();



  }
}


