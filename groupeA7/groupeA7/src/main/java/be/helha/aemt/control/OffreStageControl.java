package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.GestionOffreEJB;
import be.helha.aemt.ejb.GestionUtilisateurEJB;
import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.OffreStage;

@SessionScoped
@Named
public class OffreStageControl implements Serializable{
	
    @EJB
    private GestionOffreEJB beanOffreStage;
	
    public List<OffreStage> selectAllStage(){        
        return beanOffreStage.selectAllStage();
        
    }

}
