package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Annonce;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Offre;

@Stateless
@LocalBean
public class EvenementDAO {

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
	
	public List<Evenement> selectAllEvenement(){
		String requete ="SELECT evenement from Evenement evenement";
		Query qSelectAll=em.createQuery(requete);
		return qSelectAll.getResultList();
	}
	

	public Evenement addEvenement(Evenement u) {
		em.merge(u);
		return u;
	}
	
	public Evenement removeEvenement(Evenement u) {
		if(u.getId()==null) {
			return null;
		}
		em.remove(em.merge(u));
		return u;
	}
}
