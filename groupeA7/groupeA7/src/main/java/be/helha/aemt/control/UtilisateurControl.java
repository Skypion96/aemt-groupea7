package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.swing.JSpinner.ListEditor;

import be.helha.aemt.ejb.GestionUtilisateurEJB;
import be.helha.aemt.entities.Utilisateur;

@SessionScoped
@Named
public class UtilisateurControl implements Serializable{
	
private String nom = "Anonymous";
    
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
    
    public List<Utilisateur> selectAll(){        
        return beanUtilisateur.findAll();
        
    }
	
	

}
