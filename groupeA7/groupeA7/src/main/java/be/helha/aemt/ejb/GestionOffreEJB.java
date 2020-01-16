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
import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.OffreEmploi;
import be.helha.aemt.entities.OffreStage;
import be.helha.aemt.entities.Utilisateur;

@Stateless
public class GestionOffreEJB {

	@EJB//injection (@Inject)
    private OffreDAO offreDAO;
	
	@EJB
	private OffreStageDAO offreStageDAO;
	
	@EJB
	private OffreEmploiDAO offreEmploiDAO;
    
    public List<OffreStage> selectAllStage() {
        return offreStageDAO.selectAllStage();
    }
    
    public List<OffreEmploi> selectAllEmploi() {
        return offreEmploiDAO.selectAllEmploi();
    }
    
    public List<Offre> selectAllEmploiNV() {
        return offreDAO.selectAllEmploiNV();
    }
    
    public List<Offre> selectAllEmploiV() {
        return offreDAO.selectAllEmploiV();
    }
    
    public OffreStage AjoutOffreStage(OffreStage offre) {
    	return offreStageDAO.addOffreStage(offre);
    }

    public OffreEmploi AjoutOffreEmploi(OffreEmploi offre) {
    	return offreEmploiDAO.addOffreEmploi(offre);
    }
    
    public Offre removeOffreNV(Offre e) {
    	return offreDAO.removeOffreNV(e);
    }
    
    public Offre findId(int id) {
    	return offreDAO.findId(id);
    }
    
    public Offre updateValidation(Offre u) {
    	return offreDAO.updateValidation(u);
    }
    
    public OffreStage findById(int id) {
    	return offreStageDAO.findById(id);
    }
    
    public OffreEmploi findByIdEmploi(int id) {
    	return offreEmploiDAO.findById(id);
    }
}
