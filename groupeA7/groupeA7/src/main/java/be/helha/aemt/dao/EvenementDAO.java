package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Evenement;

@Stateless
@LocalBean
public class EvenementDAO {
	
	@PersistenceContext(unitName = "groupeA7")
    private EntityManager em;
	
	public List<Evenement> selectAll(){
		String requete ="SELECT evenement from Evenement evenement";
		Query qSelectAll=em.createQuery(requete);
		return qSelectAll.getResultList();
	}
	
	public Evenement add(Evenement u) {
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
	


}
