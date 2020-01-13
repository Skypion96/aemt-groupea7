package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Admin extends Utilisateur implements Serializable{

	public Admin(String password, String email, String nom, String prenom) {
		super(password, email, nom, prenom);
		this.setRole("Admin");
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
