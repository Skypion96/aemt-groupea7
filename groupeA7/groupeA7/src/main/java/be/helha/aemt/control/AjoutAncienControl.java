package be.helha.aemt.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import be.helha.aemt.ejb.GestionAjoutAncienEJB;
import be.helha.aemt.ejb.GestionUtilisateurEJB;
import be.helha.aemt.entities.Ancien;

@SessionScoped
@Named
public class AjoutAncienControl implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
    private GestionAjoutAncienEJB beanUtilisateur;
	

	@EJB
    private GestionUtilisateurEJB beanUtilisateurverif;

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
	private Part photo;

	
	
	public String AjoutAncien() {
		
		Ancien verif = beanUtilisateurverif.findMailAncien(email);
		
		
		
		Ancien ancien = new Ancien(password,email,nom,prenom,telephone,anneeDiplomante,adresse,cp,localite,emploiActuel,section);
		
		if(verif != null) {
			return null;
		}
		if(photo != null) {
			try {
				InputStream img = photo.getInputStream();
				byte[] bytes = new byte[2000000];
				while ((img.read(bytes)) != -1);
				ancien.setImageProfil(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		beanUtilisateur.AjoutAncien(ancien);
		return "/inscriptionsuccess.xhtml?faces-redirect=true";
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
	public Part getPhoto() {
		return photo;
	}
	public void setPhoto(Part photo) {
		this.photo = photo;
	}	
}
