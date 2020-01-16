package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class OffreEmploi extends Offre implements Serializable{

	public OffreEmploi() {
		super();
	}

	public OffreEmploi(String titre, boolean valide, Date date, Ancien ancien, String nomEntreprise,
			String adresseEntreprise, String descriptif, String section,String nomContact,String prenomContact,String mailContact) {
		super(titre, valide, date, ancien, nomEntreprise, adresseEntreprise, descriptif, section,nomContact,prenomContact,mailContact);
		this.setType("Emploi");
	}

	
	
}
