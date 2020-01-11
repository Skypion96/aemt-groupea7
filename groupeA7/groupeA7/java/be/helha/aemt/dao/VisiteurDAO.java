package be.helha.aemt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

@Stateless
@LocalBean
public class VisiteurDAO {
	
    @PersistenceContext(unitName = "leurartWebJTA")
    private EntityManager em;
    
    public List<Utilisateur> findAll() {
        return em.createQuery("SELECT utilisateur FROM Visiteur Utilisateur").getResultList();
    }

}
