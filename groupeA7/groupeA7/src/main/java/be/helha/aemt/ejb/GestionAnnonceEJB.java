package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AnnonceDAO;
import be.helha.aemt.entities.Annonce;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.OffreStage;
import be.helha.aemt.entities.Utilisateur;

@Stateless
public class GestionAnnonceEJB {

	@EJB
	private AnnonceDAO dao;
	
	public List<Annonce> selectAllAnnonce(){
		return dao.selectAllAnnonce();
	}
	
    public Annonce AjoutAnnonce(Annonce annonce) {
    	return dao.addAnnonce(annonce);
    }
    
	public List<Annonce> selectAllAnnonceByUser(Utilisateur user){
		return dao.selectAllAnnonceByUser(user);
	}
	
    public Annonce removeAnnonce(Annonce e) {
    	return dao.removeAnnonce(e);
    }
    public Annonce findId(int id) {
    	return dao.findId(id);
    }
}
