package org.BackForAdio.entiites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Metier implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String nom_metier;

	public String getNom_metier() {
		return nom_metier;
	}

	public void setNom_metier(String nom_metier) {
		this.nom_metier = nom_metier;
	}

	public Metier(String nom_metier) {
		super();
		this.nom_metier = nom_metier;
	}

	public Metier() {
		super();
	}
	
	

}
