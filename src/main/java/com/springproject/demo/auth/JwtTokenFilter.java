package com.springproject.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.DuplicatesPredicate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.jaas.SecurityContextLoginModule;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
@Autowired
    private  TokenManager tokenManager;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        final String authHeader=httpServletRequest.getHeader("Authorization");
        String username=null;
        String token=null;
        if (authHeader!=null&&authHeader.contains("Bearer ")) {
          token = authHeader.substring(7);
            try {
                 username=tokenManager.getClaims(token).getSubject();

            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

        }
        if (username!=null&&token!=null&&
                SecurityContextHolder.getContext().getAuthentication()==null){
if (tokenManager.tokenValidate(token)){
    UsernamePasswordAuthenticationToken upass=new UsernamePasswordAuthenticationToken(username,null,new ArrayList<>());
upass.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest) );
SecurityContextHolder.getContext().setAuthentication(upass);
}
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
