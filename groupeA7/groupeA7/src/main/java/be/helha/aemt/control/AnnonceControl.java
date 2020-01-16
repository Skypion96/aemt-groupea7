package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.GestionAnnonceEJB;
import be.helha.aemt.ejb.GestionUtilisateurEJB;
import be.helha.aemt.entities.Annonce;
import be.helha.aemt.entities.Utilisateur;

@SessionScoped
@Named
public class AnnonceControl implements Serializable{

	private String titre;
	private String descriptif;
	private Utilisateur user;
	
	@EJB
	private GestionAnnonceEJB beanAnnonce;
	
	@EJB
	private GestionUtilisateurEJB beanUser;
	
	public List<Annonce> selectAll2(){
		return beanAnnonce.selectAllAnnonce();
	}
	
    public Annonce ajoutAnnonce(String email) {
    	user = beanUser.findMail(email);
    	Annonce annonce = new Annonce(titre, descriptif, user);
    	return beanAnnonce.AjoutAnnonce(annonce);
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

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
    
    
}