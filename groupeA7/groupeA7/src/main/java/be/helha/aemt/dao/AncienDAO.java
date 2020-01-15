package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class AncienDAO {
	
    @PersistenceContext(unitName = "groupeA7")
    private EntityManager em;
    
    //RESOURCE_LOCAL
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
	
	//rechercher un utilisateur
	public  Ancien findMailAncien(String mail) {
		String requete ="SELECT ancien from Ancien ancien where ancien.email =:mail";
		TypedQuery<Ancien> qFind = em.createQuery(requete, Ancien.class);
		qFind.setParameter("mail", mail);
		List<Ancien> res= qFind.getResultList();
		return res.size()==0? null:res.get(0);
	}
	
	public Utilisateur remove(Ancien u) {
		if(u.getEmail()==null) {
			return null;
		}
		em.remove(em.merge(u));
		return u;
	}
	
	public List<Ancien> findSection(String section, String option){
		boolean valide = true;
		String requete ="SELECT ancien from Ancien ancien where ancien.section =:section and ancien.valide = :valide and ancien.nom =:option or ancien.prenom =:option or ancien.email =:option or ancien.anneeDiplomante =:optionNumber";
		Query qSelectAll=em.createQuery(requete);
		qSelectAll.setParameter("section", section );
		qSelectAll.setParameter("valide", valide );
		if(option=="") {
			option = null;
		}
		int optionNumber = Integer.parseInt(option);
		qSelectAll.setParameter("option", option );
		qSelectAll.setParameter("optionNumber", optionNumber);
		return qSelectAll.getResultList();
	}
	
	public List<Ancien> findAllNV(){
		boolean valide = true;
		String requete ="SELECT ancien from Ancien ancien where ancien.valide = :valide";
		Query qSelectAll=em.createQuery(requete);
		qSelectAll.setParameter("valide", valide );
		return qSelectAll.getResultList();
	}
}
