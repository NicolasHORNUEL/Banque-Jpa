package banque;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.entite.Adresse;
import banque.entite.AssuranceVie;
import banque.entite.Banque;
import banque.entite.Client;
import banque.entite.Compte;
import banque.entite.LivretA;
import banque.entite.Operation;
import banque.entite.Virement;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		// 1 BANQUE
		
		Banque banque1 = new Banque();
		banque1.setNom("La Banque Postale");
		em.persist(banque1);
		
		// 2 ADRESSE et CLIENT
		
		Adresse adresse1 = new Adresse(1, "Place de l'Étoile", 21000, "DIJON");
		Client client1 = new Client("HUBERT", "Djo", new Date(), adresse1, banque1);
		em.persist(client1);
		
		Adresse adresse2 = new Adresse(2, "Place de l'église", 69000, "LYON");
		Client client2 = new Client("DUCHAMP", "Marcel", new Date(1887-07-28), adresse2, banque1);
		em.persist(client2);
		
		// 3 COMPTE
		
		Compte compte1 = new Compte("463786287-A", 200.5);
		em.persist(compte1);
				
		LivretA livret1 = new LivretA("89798986-HG", 330.5, 1.4);
		em.persist(livret1);
		
		AssuranceVie aVie1 = new AssuranceVie("89798986-HG", 330.5, new Date(2030-01-01), 1.4);
		em.persist(aVie1);
		
		// 5 OPERATION
		
		Operation op1 = new Operation(new Date(), 150.5, "Retrait Guichet", compte1);
		em.persist(op1);
		
		Virement vir1 = new Virement(new Date(), 50.8, "Regul Aout", compte1, "05577784-Z");
		em.persist(vir1);
		
		// Insérer un compte associé à 2 clients
		client1.getComptes().add(compte1);
		client2.getComptes().add(compte1);
		
		// Insérer un client avec plusieurs comptes
		client1.getComptes().add(livret1);
		client1.getComptes().add(aVie1);

		
		et.commit();
		em.close();
		

		
		
	}

}
