package be.helha.aemt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import be.helha.aemt.entities.Admin;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.Utilisateur;

public class OffreDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	
	public OffreDAO() {
		//ON EST EN RESSOURCE_LOCAL
		emf = Persistence.createEntityManagerFactory("groupeA7");//UNIQUEMENT EN RESSOURCE LOCAL
		em = emf.createEntityManager();
		tx=em.getTransaction();
	}
	
	
	public void close() {
		em.close();
		emf.close();
	}
	
	public List<Offre> selectAll(){
		String requete ="SELECT offre from Offre offre";
		Query qSelectAll=em.createQuery(requete);
		return qSelectAll.getResultList();
	}
	

	public Offre remove(Offre u) {
		if(u.getId()==null) {
			return null;
		}
		tx.begin();
		em.remove(em.merge(u));
		tx.commit();
		return u;
	}
}
