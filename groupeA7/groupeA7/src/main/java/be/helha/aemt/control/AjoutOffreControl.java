package be.helha.aemt.control;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import be.helha.aemt.dao.AncienDAO;
import be.helha.aemt.ejb.GestionOffreEJB;
import be.helha.aemt.ejb.GestionUtilisateurEJB;
import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.OffreEmploi;
import be.helha.aemt.entities.OffreStage;
import be.helha.aemt.entities.Utilisateur;

@SessionScoped
@Named
public class AjoutOffreControl implements Serializable{

	private String titre;
	private Ancien ancien;
	private String nomEntreprise;
	private String adresseEntreprise;
	private String type;
	private String descriptif;
	private String section;
	private String mail;
	private String nomContact;
	private String prenomContact;
	private String mailContact;
	
	@EJB
    private GestionOffreEJB beanOffreStage;
	
	@EJB
	private GestionUtilisateurEJB beanUser;
	
	public Offre ajoutOffre(String email) {
		ancien = beanUser.findMailAncien(email);
		
		if(type.equals("Emploi")) {
			OffreEmploi offre = new OffreEmploi(titre, false, new Date(),ancien, nomEntreprise, adresseEntreprise, descriptif, section,nomContact,prenomContact,mailContact);
			return beanOffreStage.AjoutOffreEmploi(offre);
		}
		else {
			OffreStage offre = new OffreStage(titre, false, new Date(),ancien, nomEntreprise, adresseEntreprise, descriptif, section,nomContact,prenomContact,mailContact);
			return beanOffreStage.AjoutOffreStage(offre);
		}
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Ancien getAncien() {
		return ancien;
	}
	public void setAncien(Ancien ancien) {
		this.ancien = ancien;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getAdresseEntreprise() {
		return adresseEntreprise;
	}
	public void setAdresseEntreprise(String adresseEntreprise) {
		this.adresseEntreprise = adresseEntreprise;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}

	public String getNomContact() {
		return nomContact;
	}

	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}

	public String getPrenomContact() {
		return prenomContact;
	}

	public void setPrenomContact(String prenomContact) {
		this.prenomContact = prenomContact;
	}

	public String getMailContact() {
		return mailContact;
	}

	public void setMailContact(String mailContact) {
		this.mailContact = mailContact;
	}
	
	
}
