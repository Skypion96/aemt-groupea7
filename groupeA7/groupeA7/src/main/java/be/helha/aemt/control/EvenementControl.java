package be.helha.aemt.control;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import be.helha.aemt.ejb.GestionEvenementEJB;
import be.helha.aemt.ejb.GestionUtilisateurEJB;
import be.helha.aemt.entities.Evenement;

public class EvenementControl {

	private String titre;
	private String descriptif;
	private String date;

	
	@EJB
	private GestionEvenementEJB beanAnnonce;
	
	@EJB
	private GestionUtilisateurEJB beanUser;
	
	public List<Evenement> selectAll(){
		return beanAnnonce.selectAllEvenement();
	}
	
    public Evenement ajoutEvenement(String email) {
    	Evenement annonce = new Evenement(titre, descriptif, date);
    	return beanAnnonce.AjoutEvenement(annonce);
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

}
