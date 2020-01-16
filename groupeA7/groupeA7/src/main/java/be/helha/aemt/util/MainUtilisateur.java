package be.helha.aemt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.aemt.dao.AncienDAO;
import be.helha.aemt.entities.Admin;
import be.helha.aemt.entities.Ancien;
import be.helha.aemt.entities.Annonce;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.OffreEmploi;
import be.helha.aemt.entities.OffreStage;
import be.helha.aemt.entities.Utilisateur;

public class MainUtilisateur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Utilisateur u1 = new Ancien("helha","user","Orient","David","0476063387",2020,"2, Rue Chisaire",7000,"Mons","Chomage", "Informatique de gestion");
		Utilisateur u2 = new Admin("helha","admin","Leurart","Vincent");
		Utilisateur u3 = new Ancien("lala","Mail3","Janssens","Maxime","0476060606",2020,"12, Rue du Test",7000,"Mons","Chomage", "Informatique de gestion");

		Offre o1 = new OffreStage("Test offre stage",false,new Date() ,(Ancien)u1,"meetHelha","30, Rue de l'entreprise, 7000 MONS","Descriptif de l'entreprise","Informatique de gestion","test","test","test");
		Offre o2 = new OffreEmploi("Test offre emploi",false,new Date() ,(Ancien)u1,"meetHelha","30, Rue de l'entreprise, 7000 MONS","Descriptif de l'entreprise","Informatique de gestion","test","test","test");
		
		Annonce annonce = new Annonce("test", "test", u2, new Date());
		Evenement event = new Evenement("test", "test", "20/20/2020");
		
		File file = new File("src/main/webapp/res/no_profile.gif");
		byte[] picInBytes = new byte[(int) file.length()];
		FileInputStream fileInputStream;
		
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(picInBytes);
			fileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		((Ancien)u1).setImageProfil(picInBytes);

		//Utilisateur u3 = new Utilisateur("L3","P1","E1","user");

		//AncienDAO ancienDao = new AncienDAO();
		
		EntityManagerFactory emf;
		EntityManager em;
		EntityTransaction tx;
		 
		emf = Persistence.createEntityManagerFactory("groupeA7");
		em = emf.createEntityManager();
		tx=em.getTransaction();
		 
		 
		tx.begin();
		em.merge(u1);
		em.merge(u2);
		em.merge(u3);
		em.merge(o1);
		em.merge(o2);
		em.merge(event);
		em.merge(annonce);
		//em.persist(u3);
		tx.commit();
		
		//System.out.println(ancienDao.findSection("Informatique de gestion"));

		//ancienDao.close();
		
		em.close();
		emf.close();
		

	}
}
