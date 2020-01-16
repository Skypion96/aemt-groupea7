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

import be.helha.aemt.entities.Admin;
import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.OffreEmploi;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class OffreDAO {

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
	
	public List<Offre> selectAllEmploiNV(){
		String requete ="SELECT offre from Offre offre where offre.valide = :valide";
		Query qSelectAll=em.createQuery(requete);
		qSelectAll.setParameter("valide", false );
		return qSelectAll.getResultList();
	}
	
	public List<Offre> selectAllEmploiV(){
		String requete ="SELECT offre from Offre offre where offre.valide = :valide";
		Query qSelectAll=em.createQuery(requete);
		qSelectAll.setParameter("valide", true );
		return qSelectAll.getResultList();
	}
	
	public List<Offre> selectAllOffreByAncien(Ancien ancien){
		String requete ="SELECT offre from Offre offre where offre.ancien = :ancien";
		Query qSelectAll=em.createQuery(requete);
		qSelectAll.setParameter("ancien", ancien );
		return qSelectAll.getResultList();
	}
	
	public Offre findId(int id){
		String requete ="SELECT offre from Offre offre where offre.id = :id";
		TypedQuery<Offre> qFind = em.createQuery(requete, Offre.class);
		qFind.setParameter("id", id);
		List<Offre> res= qFind.getResultList();
		return res.size()==0? null:res.get(0);
	}

	public OffreEmploi addOffreEmploi(OffreEmploi u) {
		em.merge(u);
		return u;
	}
	
	public Offre updateValidation(Offre a) {
		a.setValide(true);
		em.merge(a);
		return a;
	}
	
	public Offre removeOffreNV(Offre u) {
		if(u.getId()==null) {
			return null;
		}
		em.remove(em.merge(u));
		return u;
	}
	//UPDATE A REFLECHIR
}
