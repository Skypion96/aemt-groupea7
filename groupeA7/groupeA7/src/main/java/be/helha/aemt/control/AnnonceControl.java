package be.helha.aemt.control;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.GestionAnnonceEJB;
import be.helha.aemt.ejb.GestionUtilisateurEJB;
import be.helha.aemt.entities.Annonce;
import be.helha.aemt.entities.Offre;
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
	
	public List<Annonce> selectAll(){
		return beanAnnonce.selectAllAnnonce();
	}
	
	public Annonce selectLastAnnonceIndex(int i) {
		return beanAnnonce.selectLastAnnonceIndex(i);
	}
	
	public List<Annonce> selectAllByUser(String mail){
		Utilisateur user = beanUser.findMail(mail);
		return beanAnnonce.selectAllAnnonceByUser(user);
	}
	
    public Annonce ajoutAnnonce(String email) {
    	user = beanUser.findMail(email);
    	Annonce annonce = new Annonce(titre, descriptif, user, new Date());
    	return beanAnnonce.AjoutAnnonce(annonce);
    }

    public Annonce removeAnnonce(int id) {
    	Annonce o = beanAnnonce.findId(id);
    	return beanAnnonce.removeAnnonce(o);
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
