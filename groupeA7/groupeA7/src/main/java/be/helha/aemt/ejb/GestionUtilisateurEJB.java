package be.helha.aemt.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.entities.Utilisateur;

@Stateless
public class GestionUtilisateurEJB{

	@EJB//injection (@Inject)
    private UtilisateurDAO dao;
    
    public List<Utilisateur> findAll() {
        return dao.selectAll();
    }


}
