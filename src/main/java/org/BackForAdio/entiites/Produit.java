package org.BackForAdio.entiites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Produit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_produit;
	private String photo;
	private String nom;
	@ManyToOne
	@JoinColumn(name="username")
	private Ourvrier Ourvrier;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date_creation;
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Long getId_produit() {
		return id_produit;
	}
	public void setId_produit(Long id_produit) {
		this.id_produit = id_produit;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Ourvrier getOurvrier() {
		return Ourvrier;
	}
	public void setOurvrier(Ourvrier ourvrier) {
		Ourvrier = ourvrier;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public Produit(String photo, String nom, Ourvrier ourvrier, Date date_creation) {
		super();
		this.photo = photo;
		this.nom=nom;
		Ourvrier = ourvrier;
		this.date_creation = date_creation;
	}
	public Produit() {
		super();
	}

	
}
