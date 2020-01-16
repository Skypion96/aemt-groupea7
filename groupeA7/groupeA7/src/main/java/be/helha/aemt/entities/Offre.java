package be.helha.aemt.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Offre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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
	private String nomContact;
	private String prenomContact;
	private String mailContact;
	
	
	
	public Offre(String titre, boolean valide, Date date, Ancien ancien, String nomEntreprise,
			String adresseEntreprise, String descriptif, String section,String nomContact,String prenomContact,String mailContact) {
		super();
		this.titre = titre;
		this.valide = valide;
		this.date = date;
		this.ancien = ancien;
		this.nomEntreprise = nomEntreprise;
		this.adresseEntreprise = adresseEntreprise;
		this.descriptif = descriptif;
		this.section = section;
		this.nomContact = nomContact;
		this.prenomContact = prenomContact;
		this.mailContact = mailContact;
	}
	
	
	public Offre() {
		super();
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offre other = (Offre) obj;
		if (adresseEntreprise == null) {
			if (other.adresseEntreprise != null)
				return false;
		} else if (!adresseEntreprise.equals(other.adresseEntreprise))
			return false;
		if (ancien == null) {
			if (other.ancien != null)
				return false;
		} else if (!ancien.equals(other.ancien))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (descriptif == null) {
			if (other.descriptif != null)
				return false;
		} else if (!descriptif.equals(other.descriptif))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomEntreprise == null) {
			if (other.nomEntreprise != null)
				return false;
		} else if (!nomEntreprise.equals(other.nomEntreprise))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (valide != other.valide)
			return false;
		return true;
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


	@Override
	public String toString() {
		return "Offre [id=" + id + ", titre=" + titre + ", valide=" + valide + ", date=" + date + ", ancien=" + ancien
				+ ", nomEntreprise=" + nomEntreprise + ", adresseEntreprise=" + adresseEntreprise + ", type=" + type
				+ ", descriptif=" + descriptif + ", section=" + section + ", nomContact=" + nomContact
				+ ", prenomContact=" + prenomContact + ", mailContact=" + mailContact + "]";
	}

	
	
}
