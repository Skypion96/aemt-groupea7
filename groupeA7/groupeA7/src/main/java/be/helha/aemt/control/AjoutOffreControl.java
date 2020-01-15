package be.helha.aemt.control;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.OffreEmploi;
import be.helha.aemt.entities.OffreStage;
import be.helha.aemt.entities.Utilisateur;

@SessionScoped
@Named
public class AjoutOffreControl implements Serializable{

	UtilisateurControl uc = new UtilisateurControl();
	private String titre;
	private boolean valide;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private Ancien ancien;
	private String nomEntreprise;
	private String adresseEntreprise;
	private String type;
	private String descriptif;
	private String section;
	
	
	
	public Offre AjoutOffre(String mail) {
		ancien = (Ancien)uc.findMail(mail);
		Offre offre = null;
		if(type == "Emploi") {
			offre = new OffreEmploi(titre, valide, new Date(), (Ancien)ancien, nomEntreprise, adresseEntreprise, descriptif, section);
		}
		else {
			offre = new OffreStage(titre, valide, new Date(),(Ancien) ancien, nomEntreprise, adresseEntreprise, descriptif, section);
		}
		return offre;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	
	
}
