package org.BackForAdio.entiites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ourvrier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	private String username;
	private String nom_ouvrier;
	private String prenom_ouvrier;
	private String numero_telephone;
	private String sexe_ouvrier;
	private int age_ouvrier;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date_creation;
    private String photo;
	@ManyToOne
	@JoinColumn(name="metier")
	private Metier metier_ouvrier;
	private String password;
	private boolean enabled;
	@ManyToMany(fetch=FetchType.EAGER)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNom_ouvrier() {
		return nom_ouvrier;
	}
	public void setNom_ouvrier(String nom_ouvrier) {
		this.nom_ouvrier = nom_ouvrier;
	}
	public String getPrenom_ouvrier() {
		return prenom_ouvrier;
	}
	public void setPrenom_ouvrier(String prenom_ouvrier) {
		this.prenom_ouvrier = prenom_ouvrier;
	}
	public String getNumero_telephone() {
		return numero_telephone;
	}
	public void setNumero_telephone(String numero_telephone) {
		this.numero_telephone = numero_telephone;
	}
	public String getSexe_ouvrier() {
		return sexe_ouvrier;
	}
	public void setSexe_ouvrier(String sexe_ouvrier) {
		this.sexe_ouvrier = sexe_ouvrier;
	}
	public int getAge_ouvrier() {
		return age_ouvrier;
	}
	public void setAge_ouvrier(int age_ouvrier) {
		this.age_ouvrier = age_ouvrier;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Metier getMetier_ouvrier() {
		return metier_ouvrier;
	}
	public void setMetier_ouvrier(Metier metier_ouvrier) {
		this.metier_ouvrier = metier_ouvrier;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Ourvrier(String username, String nom_ouvrier, String prenom_ouvrier, String numero_telephone,
			String sexe_ouvrier, int age_ouvrier, Date date_creation, String photo, Metier metier_ouvrier,
			String password, boolean enabled) {
		super();
		this.username = username;
		this.nom_ouvrier = nom_ouvrier;
		this.prenom_ouvrier = prenom_ouvrier;
		this.numero_telephone = numero_telephone;
		this.sexe_ouvrier = sexe_ouvrier;
		this.age_ouvrier = age_ouvrier;
		this.date_creation = date_creation;
		this.photo = photo;
		this.metier_ouvrier = metier_ouvrier;
		this.password = password;
		this.enabled = enabled;
	
	}
	public Ourvrier() {
		super();
	}
	
	
	

}
