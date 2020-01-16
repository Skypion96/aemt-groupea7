package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Annonce;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.OffreEmploi;

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
		String requete ="SELECT annonce from Annonce annonce ORDER BY annonce.date DESC";
		Query qSelectAll=em.createQuery(requete, Annonce.class);
		return qSelectAll.getResultList();
	}
	
	public Annonce selectLastAnnonceIndex(int i) {
		String requete ="SELECT annonce from Annonce annonce ORDER BY annonce.date DESC";
		Query qSelectAnnonceIndex = em.createQuery(requete, Annonce.class);
		qSelectAnnonceIndex.setFirstResult(i);
		List<Annonce> res= qSelectAnnonceIndex.getResultList();
		return res.size()==0? null:res.get(0);
	}
	

	public Annonce addAnnonce(Annonce u) {
		em.merge(u);
		return u;
	}
	
	public Offre removeOffreNV(Offre u) {
		if(u.getId()==null) {
			return null;
		}
		em.remove(em.merge(u));
		return u;
	}
}
