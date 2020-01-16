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
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Ancien;
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
	
	
	public void close() {
		em.close();
		emf.close();
	}*/
	
	public List<OffreStage> selectAllStage(){
		String requete ="SELECT offreStage from OffreStage offreStage where offreStage.valide = :valide";
		Query qSelectAll=em.createQuery(requete);
		qSelectAll.setParameter("valide", true );
		return qSelectAll.getResultList();
	}
	

	public OffreStage addOffreStage(OffreStage u) {
		em.merge(u);
		return u;
	}
	
	public OffreStage findById(int id) {
		String requete = "SELECT offreStage from OffreStage offreStage where offreStage.id = :id";
		TypedQuery<OffreStage> qFind = em.createQuery(requete, OffreStage.class);
		qFind.setParameter("id", id);
		List<OffreStage> res= qFind.getResultList();
		return res.size()==0? null:res.get(0);
	}
	
	//UPDATE A REFLECHIR
}
