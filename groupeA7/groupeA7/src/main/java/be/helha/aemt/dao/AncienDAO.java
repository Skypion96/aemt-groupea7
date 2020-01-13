package be.helha.aemt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Utilisateur;

public class AncienDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	public AncienDAO() {
		//ON EST EN RESSOURCE_LOCAL
		emf = Persistence.createEntityManagerFactory("groupeA7");//UNIQUEMENT EN RESSOURCE LOCAL
		em = emf.createEntityManager();
		tx=em.getTransaction();
	}
	
	
	public void close() {
		em.close();
		emf.close();
	}
	
	public List<Ancien> selectAll(){
		String requete ="SELECT ancien from Ancien ancien";
		Query qSelectAll=em.createQuery(requete);
		return qSelectAll.getResultList();
	}
	
	public Utilisateur add(Ancien u) {
		tx.begin();		
		em.merge(u);
		tx.commit();
		return u;
	}
	
	public Utilisateur remove(Ancien u) {
		if(u.getEmail()==null) {
			return null;
		}
		tx.begin();
		em.remove(em.merge(u));
		tx.commit();
		return u;
	}
}
