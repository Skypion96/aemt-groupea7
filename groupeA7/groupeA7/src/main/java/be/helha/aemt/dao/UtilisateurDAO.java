package be.helha.aemt.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Utilisateur;

public class UtilisateurDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	
	
	public UtilisateurDAO() {
		//ON EST EN RESSOURCE_LOCAL
		emf = Persistence.createEntityManagerFactory("leurartVisiteur");//UNIQUEMENT EN RESSOURCE LOCAL
		em = emf.createEntityManager();
		tx=em.getTransaction();
	}
	
	public void close() {
		em.close();
		emf.close();
	}
	
	public List<Utilisateur> selectAll(){
		String requete ="SELECT utilisateur from Utilisateur utilisateur";
		Query qSelectAll=em.createQuery(requete);
		return qSelectAll.getResultList();
	}
	
	public Utilisateur add(Utilisateur u) {
		u = new Utilisateur("Roger","null","rien","user");
		tx.begin();
		em.merge(u);
		tx.commit();
		return u;
	}
	
	//rechercher un utilisateur
	public Utilisateur find(Utilisateur u) {
		String requete ="SELECT u from Utilisateur u where u.login =:plogin";
		TypedQuery<Utilisateur> qFind = em.createQuery(requete, Utilisateur.class);
		qFind.setParameter("plogin", u.getLogin());
		List<Utilisateur> res= qFind.getResultList();
		return res.size()==0? null:res.get(0);
	}
	
	
	// supprimer les utilisateurs en fonction de leur login
	public Utilisateur remove(Utilisateur u) {

		if(u.getId()==null) {
			return null;
		}
		tx.begin();
		em.remove(em.merge(u));
		tx.commit();
		return u;
	}
	
	// supprimer les utilisateurs en fonction de leur login
	public void removeAllByLogin(Utilisateur u) {
		String requete ="DELETE FROM Utilisateur u where u.login =?1";
		Query qDelete=em.createQuery(requete);
		tx.begin();
		qDelete.setParameter(1, u.getLogin()).executeUpdate();
		tx.commit();
	}
	
	//RECHERCHE A PARTIR DU CODE POSTAL
	
	public List<Utilisateur> findCP(int cp) {
		String requete ="SELECT u from Utilisateur u join u.adresse a where a.codePostal =:cp";
		TypedQuery<Utilisateur> qFind = em.createQuery(requete, Utilisateur.class);
		qFind.setParameter("cp", cp);
		List<Utilisateur> res= qFind.getResultList();
		return res;
	}
	

	

	


}
