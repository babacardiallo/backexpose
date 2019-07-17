/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sn.tdsi.service;

import org.sn.tdsi.entiites.AppRole;
import org.sn.tdsi.entiites.AppUser;

/**
 *
 * @author babacar
 */
public interface AccountService {
    
    public AppUser saveUser(AppUser appUser);
    public AppRole saveRole(AppRole appRole);
    public void addRoleToUser(String username, String role);
    public AppUser findUserByUsername(String username);
}
