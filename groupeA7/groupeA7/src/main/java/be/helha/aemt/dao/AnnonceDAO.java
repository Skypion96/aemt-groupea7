package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Annonce;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.OffreEmploi;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class AnnonceDAO {

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
	
	public List<Annonce> selectAllAnnonce(){
		String requete ="SELECT annonce from Annonce annonce";
		Query qSelectAll=em.createQuery(requete);
		return qSelectAll.getResultList();
	}
	
	public Annonce findId(int id){
		String requete ="SELECT annonce from Annonce annonce where annonce.id = :id";
		Query qFind=em.createQuery(requete);
		qFind.setParameter("id", id);
		List<Annonce> res= qFind.getResultList();
		return res.size()==0? null:res.get(0);
		}
	
	public List<Annonce> selectAllAnnonceByUser(Utilisateur user){
		String requete ="SELECT annonce from Annonce annonce where annonce.user =:user";
		Query qSelectAll=em.createQuery(requete);
		qSelectAll.setParameter("user", user );
		return qSelectAll.getResultList();
	}
	

	public Annonce addAnnonce(Annonce u) {
		em.merge(u);
		return u;
	}
	
	public Annonce removeAnnonce(Annonce u) {
		if(u==null) {
			return null;
		}
		em.remove(em.merge(u));
		return u;
	}
}
