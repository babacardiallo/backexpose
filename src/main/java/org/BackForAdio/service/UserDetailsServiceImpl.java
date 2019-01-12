/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.BackForAdio.service;

import java.util.ArrayList;
import java.util.Collection;
import org.BackForAdio.entiites.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author babacar
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        AppUser appUser = accountService.findUserByUsername(username);
        
        if(appUser==null) throw new UsernameNotFoundException(username);
        
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        
        appUser.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        
        return new User(appUser.getUsername(), appUser.getPassword(), authorities);
    }
    
    
    
}
