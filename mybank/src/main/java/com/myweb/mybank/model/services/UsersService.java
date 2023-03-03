package com.myweb.mybank.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.myweb.mybank.model.entities.User;
import com.myweb.mybank.model.models.UserModel;
import com.myweb.mybank.model.repositories.UserRepository;

public class UsersService implements UserDetailsService{

    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new UserModel(user);
    }
    
}
