package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.OffreEmploi;
import be.helha.aemt.entities.OffreStage;

@Stateless
@LocalBean
public class OffreStageDAO {
	
	
	
	@PersistenceContext(unitName = "groupeA7")
    private EntityManager em;

	/*private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	
	public OffreStageDAO() {
		//ON EST EN RESSOURCE_LOCAL
		emf = Persistence.createEntityManagerFactory("groupeA7");//UNIQUEMENT EN RESSOURCE LOCAL
		em = emf.createEntityManager();
		tx=em.getTransaction();
	}
	
	
	/*public void close() {
		em.close();
		emf.close();
	}*/
	
	public List<OffreStage> selectAll(){
		String requete ="SELECT offreStage from OffreStage offreEmploi";
		Query qSelectAll=em.createQuery(requete);
		return qSelectAll.getResultList();
	}
	

	/*public OffreStage add(OffreStage u) {
		tx.begin();		
		em.merge(u);
		tx.commit();
		return u;
	}*/
	
	//UPDATE A REFLECHIR
}
