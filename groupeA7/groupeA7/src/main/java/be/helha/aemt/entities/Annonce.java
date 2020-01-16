package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Annonce implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titre;
	private String descriptif;
	private Utilisateur user;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public Annonce(String titre, String descriptif, Utilisateur user, Date date) {
		super();
		this.titre = titre;
		this.descriptif = descriptif;
		this.user = user;
		this.date = date;
	}
	
	public Annonce() {}
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
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	
	

}
