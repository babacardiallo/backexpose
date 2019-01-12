/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.BackForAdio.service;

import org.BackForAdio.entiites.AppRole;
import org.BackForAdio.entiites.AppUser;
import org.BackForAdio.repository.AppRoleRepository;
import org.BackForAdio.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author babacar
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;
    
    @Override
    public AppUser saveUser(AppUser appUser) {
        
        String hashpass = bCryptPasswordEncoder.encode(appUser.getPassword());
        
        appUser.setPassword(hashpass);
        
        return appUserRepository.save(appUser);
    } 

    @Override
    public AppRole saveRole(AppRole appRole) {
        
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByroleName(role);
        appUser.getRoles().add(appRole);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        
        return appUserRepository.findByUsername(username);

    }
    
}
