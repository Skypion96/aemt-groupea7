package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class OffreStage extends Offre implements Serializable{

	
	public OffreStage() {
		super();
	}

	public OffreStage(String titre, boolean valide, Date date, Ancien ancien, String nomEntreprise,
			String adresseEntreprise, String descriptif, String section) {
		super(titre, valide, date, ancien, nomEntreprise, adresseEntreprise, descriptif, section);
		this.setType("Stage");
	}

	
}
