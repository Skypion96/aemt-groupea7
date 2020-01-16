package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AnnonceDAO;
import be.helha.aemt.entities.Annonce;
import be.helha.aemt.entities.OffreStage;

@Stateless
public class GestionAnnonceEJB {

	@EJB
	private AnnonceDAO dao;
	
	public List<Annonce> selectAllAnnonce(){
		return dao.selectAllAnnonce();
	}
	
	public Annonce selectLastAnnonceIndex(int i) {
		return dao.selectLastAnnonceIndex(i);
	}
	
    public Annonce AjoutAnnonce(Annonce annonce) {
    	return dao.addAnnonce(annonce);
    }
}
