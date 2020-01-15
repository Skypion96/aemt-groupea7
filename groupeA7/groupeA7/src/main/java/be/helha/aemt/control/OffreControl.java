package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.GestionOffreEJB;
import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.OffreStage;
import be.helha.aemt.entities.Utilisateur;

@SessionScoped
@Named
public class OffreControl implements Serializable{
	
	@EJB
	private GestionOffreEJB offreBean;

    public List<OffreStage> selectAllStage(){        
        return offreBean.findAllStage();
    }
}
