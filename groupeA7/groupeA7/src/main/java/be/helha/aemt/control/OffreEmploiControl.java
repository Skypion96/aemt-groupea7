package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.GestionOffreEJB;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.OffreEmploi;
import be.helha.aemt.entities.OffreStage;

@SessionScoped
@Named
public class OffreEmploiControl implements Serializable{

	@EJB
    private GestionOffreEJB beanOffreStage;
	
    public List<OffreEmploi> selectAllEmploi(){        
        return beanOffreStage.selectAllEmploi(); 
    }
    
    public List<Offre> selectAllEmploiNV() {
        return beanOffreStage.selectAllEmploiNV();
    } 
}
