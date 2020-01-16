package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.GestionOffreEJB;
import be.helha.aemt.ejb.GestionUtilisateurEJB;
import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.OffreStage;

@SessionScoped
@Named
public class OffreStageControl implements Serializable{
	
    @EJB
    private GestionOffreEJB beanOffreStage;
    
    @EJB
    private GestionUtilisateurEJB beanAncien;
    
    private int id;
	
    public List<OffreStage> selectAllStage(){        
        return beanOffreStage.selectAllStage();
        
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String displayOffreStage(int id) {
    	String page="/affichageOffreStage.xhtml?faces-redirect=true";
    	setId(id);
    	return page;
    }
	
	public Offre findId(int id) {
		return beanOffreStage.findId(id);
	}
	
	public List<Offre> findByAncien(String mail){
		Ancien ancien = beanAncien.findMailAncien(mail);
		return beanOffreStage.findByAncien(ancien);
	}

}
