package be.helha.aemt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import be.helha.aemt.entities.OffreEmploi;

public class OffreEmploiDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	
	public OffreEmploiDAO() {
		//ON EST EN RESSOURCE_LOCAL
		emf = Persistence.createEntityManagerFactory("groupeA7");//UNIQUEMENT EN RESSOURCE LOCAL
		em = emf.createEntityManager();
		tx=em.getTransaction();
	}
	
	
	public void close() {
		em.close();
		emf.close();
	}
	
	public List<OffreEmploi> selectAll(){
		String requete ="SELECT offreEmploi from OffreEmploi offreEmploi";
		Query qSelectAll=em.createQuery(requete);
		return qSelectAll.getResultList();
	}
	

	public OffreEmploi add(OffreEmploi u) {
		tx.begin();		
		em.merge(u);
		tx.commit();
		return u;
	}
	
	//UPDATE A REFLECHIR
}
