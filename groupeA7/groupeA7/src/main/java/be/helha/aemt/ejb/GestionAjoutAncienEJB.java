package be.helha.aemt.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AncienDAO;
import be.helha.aemt.entities.Ancien;

@Stateless
public class GestionAjoutAncienEJB {

	@EJB
	private AncienDAO dao;
	
	public Ancien AjoutAncien(Ancien ancien) {
		return dao.add(ancien);
	}
}
