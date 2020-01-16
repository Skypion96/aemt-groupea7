package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.JSpinner.ListEditor;

import org.omnifaces.cdi.GraphicImageBean;

import be.helha.aemt.ejb.GestionUtilisateurEJB;
import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.Utilisateur;

@ApplicationScoped
@Named
public class ImageControl implements Serializable{
	
    private byte[] imageFromMail;
    
	@EJB
    private GestionUtilisateurEJB beanUtilisateur;

	public byte[] getImageFromMail() {
		return imageFromMail;
	}

	public void setImageFromMail(byte[] imageFromMail) {
		this.imageFromMail = imageFromMail;
	}
	
	public byte[] findImageFromMail(String mail) {
		return ((Ancien)(beanUtilisateur.findMail(mail))).getImageProfil();
	}
}
