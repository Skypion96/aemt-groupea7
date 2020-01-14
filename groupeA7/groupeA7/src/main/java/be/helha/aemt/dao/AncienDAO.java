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

import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class AncienDAO {
	
    @PersistenceContext(unitName = "groupeA7")
    private EntityManager em;

	/*private EntityManagerFactory emf;
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
	}*/
	
	public List<Ancien> selectAll(){
		String requete ="SELECT ancien from Ancien ancien";
		Query qSelectAll=em.createQuery(requete);
		return qSelectAll.getResultList();
	}
	
	public Ancien add(Ancien u) {
		em.merge(u);
		return u;
	}
	
	/*public Utilisateur remove(Ancien u) {
		if(u.getEmail()==null) {
			return null;
		}
		tx.begin();
		em.remove(em.merge(u));
		tx.commit();
		return u;
	}*/
	
	public List<Ancien> findSection(String section){
		boolean valide = true;
		String requete ="SELECT ancien from Ancien ancien where ancien.section =:section and ancien.valide = :valide";
		Query qSelectAll=em.createQuery(requete);
		qSelectAll.setParameter("section", section );
		qSelectAll.setParameter("valide", valide );
		return qSelectAll.getResultList();
	}
}
