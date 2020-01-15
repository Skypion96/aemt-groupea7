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
import be.helha.aemt.entities.Utilisateur;

@SessionScoped
@Named
public class UtilisateurControl implements Serializable{
	
	private String nom = "Anonymous";
	private String role;
    
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
        return beanUtilisateur.findSectionAncien(section);
    }
    
    public Ancien findMailAncien(String mail) {
    	return beanUtilisateur.findMailAncien(mail);
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
