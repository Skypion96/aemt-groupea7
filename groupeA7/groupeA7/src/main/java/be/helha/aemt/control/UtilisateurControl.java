package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.swing.JSpinner.ListEditor;

import be.helha.aemt.ejb.GestionVisiteurEJB;
import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

@SessionScoped
@Named
public class UtilisateurControl implements Serializable{
	
private String nom = "Anonymous";
    
    @EJB
    private GestionVisiteurEJB beanUtilisateur;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    public String doList() {
        return "list.xhtml";
    }
    
    public List<Visiteur> selectAll(){        
        return beanUtilisateur.findAll();
        
    }
	
	

}
