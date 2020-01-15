package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.GestionAjoutAncienEJB;
import be.helha.aemt.entities.Ancien;

@SessionScoped
@Named
public class AjoutAncienControl implements Serializable{
	
    @EJB
    private GestionAjoutAncienEJB beanUtilisateur;

	private String email;	
	private String password;
	private String nom;
	private String prenom;
	private String role;
	private String telephone;
	private int anneeDiplomante;
	private String adresse;
	private int cp;
	private String localite;
	private String emploiActuel;
	private String section;

	
	
	public Ancien AjoutAncien() {
		
		Ancien ancien = new Ancien(password,email,nom,prenom,telephone,2020,adresse,0,localite,emploiActuel,section);
		return beanUtilisateur.AjoutAncien(ancien);
	}
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getTelephone() {
		return telephone;
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
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	public void clearAjout() {
		this.nom = "";
		/*email;	
		password;
		nom;
		prenom;
		role;
		telephone;
		private int anneeDiplomante;
		private String adresse;
		private int cp;
		private String localite;
		private String emploiActuel;
		private String section;*/
	}
	
}
