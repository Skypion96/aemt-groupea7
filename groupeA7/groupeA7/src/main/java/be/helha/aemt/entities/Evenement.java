package be.helha.aemt.entities;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Evenement {
	
	private String titre;
	private String descriptif;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private Admin createur;
	public Evenement(String titre, String descriptif, Date date, Admin createur) {
		super();
		this.titre = titre;
		this.descriptif = descriptif;
		this.date = date;
		this.createur = createur;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Admin getCreateur() {
		return createur;
	}
	public void setCreateur(Admin createur) {
		this.createur = createur;
	}
	
	
}
