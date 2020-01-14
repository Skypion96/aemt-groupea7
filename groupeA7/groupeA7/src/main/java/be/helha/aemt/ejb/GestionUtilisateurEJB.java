package be.helha.aemt.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import be.helha.aemt.dao.AdminDAO;
import be.helha.aemt.dao.AncienDAO;
import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Utilisateur;

@Stateless
public class GestionUtilisateurEJB{

	/*@EJB//injection (@Inject)
    private UtilisateurDAO utilisateurDAO;
	*/
	@EJB
	private AncienDAO ancienDAO;
	
	/*@EJB
	private AdminDAO adminDAO;*/
    
    public List<Ancien> findAll() {
        return ancienDAO.selectAll();
    }
    
   /* public Utilisateur find(Utilisateur u) {
    	return utilisateurDAO.find(u);
    }

    public List<Utilisateur> findSection(String section) {
        return ancienDAO.findSection(section);
    }*/
}
