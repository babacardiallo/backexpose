/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sn.tdsi.repository;

import org.sn.tdsi.entiites.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author babacar
 */
public interface AppRoleRepository extends JpaRepository<AppRole, Long>{
    
    public AppRole findByroleName(String roleName);
}
