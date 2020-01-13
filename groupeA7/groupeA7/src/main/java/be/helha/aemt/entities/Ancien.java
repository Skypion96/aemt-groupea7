package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Ancien extends Utilisateur implements Serializable{


	private String telephone;
	private int anneeDiplomante;
	private String adresse;
	private int cp;
	private String localite;
	private String emploiActuel;
	//private Image photo;

	
	public String getTelephone() {
		return telephone;
	}

	public Ancien(String password, String email, String nom, String prenom, String telephone, int anneeDiplomante,
			String adresse, int cp, String localite, String emploiActuel) {
		super(password, email, nom, prenom);
		this.telephone = telephone;
		this.anneeDiplomante = anneeDiplomante;
		this.adresse = adresse;
		this.cp = cp;
		this.localite = localite;
		this.emploiActuel = emploiActuel;
		this.setRole("Ancien");
	}
	
	

	public Ancien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getAnneeDiplomante() {
		return anneeDiplomante;
	}
	public void setAnneeDiplomante(int anneeDiplomante) {
		this.anneeDiplomante = anneeDiplomante;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	public String getEmploiActuel() {
		return emploiActuel;
	}
	public void setEmploiActuel(String emploiActuel) {
		this.emploiActuel = emploiActuel;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ancien other = (Ancien) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (anneeDiplomante != other.anneeDiplomante)
			return false;
		if (cp != other.cp)
			return false;
		if (emploiActuel == null) {
			if (other.emploiActuel != null)
				return false;
		} else if (!emploiActuel.equals(other.emploiActuel))
			return false;
		if (localite == null) {
			if (other.localite != null)
				return false;
		} else if (!localite.equals(other.localite))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}
	
	
	
}
