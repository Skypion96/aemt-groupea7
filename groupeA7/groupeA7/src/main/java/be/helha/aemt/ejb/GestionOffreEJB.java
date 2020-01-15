package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AdminDAO;
import be.helha.aemt.dao.AncienDAO;
import be.helha.aemt.dao.OffreDAO;
import be.helha.aemt.dao.OffreEmploiDAO;
import be.helha.aemt.dao.OffreStageDAO;
import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.OffreStage;
import be.helha.aemt.entities.Utilisateur;

@Stateless
public class GestionOffreEJB {

	/*@EJB//injection (@Inject)
    private OffreDAO offreDAO;*/
	
	@EJB
	private OffreStageDAO offreStageDAO;
	
	/*@EJB
	private OffreEmploiDAO offreEmploiDAO;*/
    
    public List<OffreStage> selectAllStage() {
        return offreStageDAO.selectAllStage();
    }

}
