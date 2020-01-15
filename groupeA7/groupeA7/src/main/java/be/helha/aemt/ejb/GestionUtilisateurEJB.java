package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AdminDAO;
import be.helha.aemt.dao.AncienDAO;
import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Utilisateur;

@Stateless
public class GestionUtilisateurEJB{

	@EJB//injection (@Inject)
    private UtilisateurDAO utilisateurDAO;
	
	@EJB
	private AncienDAO ancienDAO;
	
	@EJB
	private AdminDAO adminDAO;
    
    public List<Ancien> findAllAncien() {
        return ancienDAO.selectAll();
    }
    
    public Utilisateur find(Utilisateur u) {
    	return utilisateurDAO.find(u);
    }
    
    public Utilisateur findMail(String mail) {
    	return utilisateurDAO.findMail(mail);
    }

    public List<Ancien> findSectionAncien(String section) {
        return ancienDAO.findSection(section);
    }
}
