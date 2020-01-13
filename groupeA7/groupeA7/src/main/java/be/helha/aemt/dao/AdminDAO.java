package be.helha.aemt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import be.helha.aemt.entities.Admin;
import be.helha.aemt.entities.Utilisateur;

public class AdminDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	
	public AdminDAO() {
		//ON EST EN RESSOURCE_LOCAL
		emf = Persistence.createEntityManagerFactory("groupeA7");//UNIQUEMENT EN RESSOURCE LOCAL
		em = emf.createEntityManager();
		tx=em.getTransaction();
	}
	
	
	public void close() {
		em.close();
		emf.close();
	}
	
	public List<Admin> selectAll(){
		String requete ="SELECT admin from Admin admin";
		Query qSelectAll=em.createQuery(requete);
		return qSelectAll.getResultList();
	}
	
	public Utilisateur add(Admin u) {
		tx.begin();		
		em.merge(u);
		tx.commit();
		return u;
	}
	
	public Utilisateur remove(Admin u) {
		if(u.getEmail()==null) {
			return null;
		}
		tx.begin();
		em.remove(em.merge(u));
		tx.commit();
		return u;
	}
}
