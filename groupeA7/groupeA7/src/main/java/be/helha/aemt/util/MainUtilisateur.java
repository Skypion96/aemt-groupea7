package be.helha.aemt.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

public class MainUtilisateur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Utilisateur u1 = new Utilisateur("L1","P1","E1","admin");
		Utilisateur u2 = new Utilisateur("L2","P1","E1","user");
		Utilisateur u3 = new Utilisateur("L3","P1","E1","user");


		Visiteur v1 = new Visiteur("192.193.194.195");
		
		EntityManagerFactory emf;
		EntityManager em;
		EntityTransaction tx;
		 
		emf = Persistence.createEntityManagerFactory("groupeA7");
		em = emf.createEntityManager();
		tx=em.getTransaction();
		 
		 
		tx.begin();
		em.persist(v1);
		em.persist(u1);
		em.persist(u2);
		em.persist(u3);
		tx.commit();
		
		


		
		em.close();
		emf.close();
		
		//"test"

	}
}
