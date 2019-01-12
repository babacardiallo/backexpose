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
public class Note implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_note;
	private String appreciation;
	private double note;
	@ManyToOne
	@JoinColumn(name="username")
	private Ourvrier ourvrier;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date_note;
	public Long getId_note() {
		return id_note;
	}
	public void setId_note(Long id_note) {
		this.id_note = id_note;
	}
	public String getAppreciation() {
		return appreciation;
	}
	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public Ourvrier getOurvrier() {
		return ourvrier;
	}
	public void setOurvrier(Ourvrier ourvrier) {
		this.ourvrier = ourvrier;
	}
	public Date getDate_note() {
		return date_note;
	}
	public void setDate_note(Date date_note) {
		this.date_note = date_note;
	}
	public Note(String appreciation, double note, Ourvrier ourvrier, Date date_note) {
		super();
		this.appreciation = appreciation;
		this.note = note;
		this.ourvrier = ourvrier;
		this.date_note = date_note;
	}
	public Note() {
		super();
	}
	
	

}
