package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;

@Entity
public class Ancien extends Utilisateur implements Serializable{


	private String telephone;
	private int anneeDiplomante;
	private String adresse;
	private int cp;
	private String localite;
	private String emploiActuel;
	
	@Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] imageProfil;

	private String section;
	private boolean valide;
	
	public String getTelephone() {
		return telephone;
	}

	public Ancien(String password, String email, String nom, String prenom, String telephone, int anneeDiplomante,
			String adresse, int cp, String localite, String emploiActuel,String section) {
		super(password, email, nom, prenom);
		this.telephone = telephone;
		this.anneeDiplomante = anneeDiplomante;
		this.adresse = adresse;
		this.cp = cp;
		this.localite = localite;
		this.emploiActuel = emploiActuel;
		this.setRole("Ancien");
		this.section = section;
		this.setValide(false);
	}
	
	

	public Ancien() {
		super();
		// TODO Auto-generated constructor stub
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

	public byte[] getImageProfil() {
		return imageProfil;
	}

	public void setImageProfil(byte[] imageProfil) {
		this.imageProfil = imageProfil;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	
}
