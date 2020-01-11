package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Visiteur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String adresseIP;
	public Visiteur(String adresseIP) {
		super();
		this.adresseIP = adresseIP;
	}
	public Visiteur() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdresseIP() {
		return adresseIP;
	}
	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}
	
	@Override
	public String toString() {
		return "Visiteur : id : " + id + ", adresseIP : " + adresseIP;
	}

	
}
