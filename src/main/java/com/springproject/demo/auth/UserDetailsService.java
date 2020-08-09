package com.springproject.demo.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private Map<String,String> users=new HashMap<>();
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostConstruct
    public void init(){
        users.put("1",bCryptPasswordEncoder.encode("1"));
    }




    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (users.containsKey(s))
        return new User(s,users.get(s),new ArrayList<>());
    throw  new UsernameNotFoundException(s);
    }

}
