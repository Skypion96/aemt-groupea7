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

import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class UtilisateurDAO {
	@PersistenceContext(unitName = "groupeA7")
	private EntityManager em;
	
//RESOURCE_LOCAL
//	private EntityManagerFactory emf;
//	private EntityManager em;
//	private EntityTransaction tx;
//	
//	
//	public UtilisateurDAO() {
//		//ON EST EN RESSOURCE_LOCAL
//		emf = Persistence.createEntityManagerFactory("groupeA7");//UNIQUEMENT EN RESSOURCE LOCAL
//		em = emf.createEntityManager();
//		tx=em.getTransaction();
//	}
//	
//	public void close() {
//		em.close();
//		emf.close();
//	}
	
	public List<Utilisateur> selectAll(){
		String requete ="SELECT utilisateur from Utilisateur utilisateur";
		Query qSelectAll=em.createQuery(requete);
		return qSelectAll.getResultList();
	}
	
	public Utilisateur add(Utilisateur u) {
		em.merge(u);
		return u;
	}
	
	//rechercher un utilisateur
	public Utilisateur find(Utilisateur u) {
		String requete ="SELECT u from Utilisateur u where u.mail =:mail";
		TypedQuery<Utilisateur> qFind = em.createQuery(requete, Utilisateur.class);
		qFind.setParameter("mail", u.getEmail());
		List<Utilisateur> res= qFind.getResultList();
		return res.size()==0? null:res.get(0);
	}
	
	
	// supprimer les utilisateurs en fonction de leur login
	public Utilisateur remove(Utilisateur u) {

		if(u.getEmail()==null) {
			return null;
		}
		em.remove(em.merge(u));
		return u;
	}
	
	//RECHERCHE A PARTIR DU MAIL
	public Utilisateur findMail(String mail) {
		String requete ="SELECT u from Utilisateur u where u.mail =:mail";
		TypedQuery<Utilisateur> qFind = em.createQuery(requete, Utilisateur.class);
		qFind.setParameter("mail", mail);
		List<Utilisateur> res= qFind.getResultList();
		return res.size()==0? null:res.get(0);
	}
	

	

	


}
