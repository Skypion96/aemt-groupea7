package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.swing.JSpinner.ListEditor;

import be.helha.aemt.ejb.GestionUtilisateurEJB;
import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.Utilisateur;

@SessionScoped
@Named
public class UtilisateurControl implements Serializable{
	
	private String nom = "Anonymous";
	private String role;
	private String option;
	private String ancienMailChoose;
    
    @EJB
    private GestionUtilisateurEJB beanUtilisateur;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    public String doList() {
        return "list.xhtml";
    }
    
    public List<Ancien> selectAllAncien(){        
        return beanUtilisateur.findAllAncien();
        
    }
    
    public Utilisateur find(Utilisateur u) {
    	return beanUtilisateur.find(u);
    }
    
    public Utilisateur findMail(String mail) {
    	return beanUtilisateur.findMail(mail);
    }

    public List<Ancien> findSectionAncien(String section) {
        return beanUtilisateur.findSectionAncien(section, option);
    }
    
    public Ancien findMailAncien(String mail) {
    	return beanUtilisateur.findMailAncien(mail);
    }
    
    public List<Ancien> findAllAncienNV() {
        return beanUtilisateur.findAllAncienNV();
    }
    
    public List<Ancien> findAllAncienV() {
        return beanUtilisateur.findAllAncienV();
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	
    public String getAncienMailChoose() {
		return ancienMailChoose;
	}

	public void setAncienMailChoose(String ancienMailChoose) {
		this.ancienMailChoose = ancienMailChoose;
	}

	public Ancien removeAncienNV(String mail) {
    	Ancien o = beanUtilisateur.findMailAncien(mail);
    	return beanUtilisateur.removeByEmail(o);
    }

    public Ancien updateValidation(String mail) {
    	Ancien o = beanUtilisateur.findMailAncien(mail);
    	return beanUtilisateur.updateValidation(o);

    }
    
    public String displayUtilisateur(String mail) {
    	String page="/profilAncien.xhtml?logout=true&faces-redirect=true";
    	setAncienMailChoose(mail);
    	return page;
    }
}
