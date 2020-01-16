package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EvenementDAO;
import be.helha.aemt.entities.Evenement;

@Stateless
public class GestionEvenementEJB {

	@EJB
	private EvenementDAO dao;
	
	public List<Evenement> selectAllEvenement(){
		return dao.selectAllEvenement();
	}
	
    public Evenement AjoutEvenement(Evenement event) {
    	return dao.addEvenement(event);
    }
}
