package be.helha.aemt.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import be.helha.aemt.dao.VisiteurDAO;
import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

@Stateless
public class GestionVisiteurEJB{

	@EJB//injection (@Inject)
    private VisiteurDAO dao;
    
    public List<Visiteur> findAll() {
        return dao.findAll();
    }


}
