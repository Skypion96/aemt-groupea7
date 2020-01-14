package be.helha.aemt.entities;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.google.common.hash.Hashing;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Utilisateur  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String email;	
	private String password;
	private String nom;
	private String prenom;
	private String role;
	

	public Utilisateur() {
	}

	public Utilisateur(String password, String email,String nom,String prenom) {
		this.password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		System.out.println(password + " + " + this.password);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (!email.equals(other.email)) {
			return false;
		} 
		return true;
	}

	@Override
	public String toString() {
		return "Utilisateur [email=" + email + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ ", role=" + role + "]";
	}

	

	
	

}
