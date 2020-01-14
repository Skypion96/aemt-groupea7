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
import be.helha.aemt.entities.Offre;
import be.helha.aemt.entities.OffreEmploi;
import be.helha.aemt.entities.OffreStage;
import be.helha.aemt.entities.Utilisateur;

public class MainUtilisateur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Utilisateur u1 = new Ancien("lala","Mail1","Maxime","Yes","0202020",2020,"coucou",7000,"Mons","Chomage", "Assistant de direction");
		Utilisateur u2 = new Admin("lala","Mail2","Maxime","No");
		Utilisateur u3 = new Ancien("lala","Mail3","PE","Yes","0202020",2020,"coucou",7000,"Mons","Chomage", "Assistant de direction");

		Offre o1 = new OffreStage("Salut mon pote",false,new Date() ,(Ancien)u1,"meetHelha","rue des vieux","test","test");
		Offre o2 = new OffreEmploi("Salut mon pote",false,new Date() ,(Ancien)u1,"meetHelha","rue des vieux","test","test");
		
		File file = new File("src/main/webapp/res/Tesla.jpg");
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

		AncienDAO ancienDao = new AncienDAO();
		
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
		//em.persist(u3);
		tx.commit();
		
		System.out.println(ancienDao.findSection("Assistant de direction"));

		ancienDao.close();
		
		em.close();
		emf.close();
		

	}
}
