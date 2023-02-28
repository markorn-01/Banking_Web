package com.myweb.mybank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DetailsService implements UserDetailsService{

    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        
        User user = repo.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new Details(user);
    }
    
}
