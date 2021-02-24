package banque;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.entite.Adresse;
import banque.entite.Banque;
import banque.entite.Client;
import banque.entite.Compte;
import banque.entite.LivretA;
import banque.entite.Operation;

public class TestJpa {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		// 1 BANQUE
		
		Banque b1 = new Banque();
		b1.setNom("La Banque Postale");
		em.persist(b1);
		
		// 2 ADRESSE et CLIENT
		
		Adresse a1 = new Adresse();
		a1.setCodePostale(21000);
		a1.setNumero(1);
		a1.setRue("Place de l'Étoile");
		a1.setVille("DIJON");
		Client client1 = new Client();
		client1.setNom("HUBERT");
		client1.setPrenom("Djo");
		client1.setDateNaissance(new Date());
		client1.setAdresse(a1);
		em.persist(client1);
		
		// 3 COMPTE
		
		Compte ct1 = new Compte();
		ct1.setNumero("463786287-A");
		ct1.setSolde(200);
		em.persist(ct1);
		client1.getComptes().add(ct1);
				
		LivretA lva1 = new LivretA();
		lva1.setNumero("89798986-HG");
		lva1.setSolde(300);
		lva1.setTaux(1.4);
		em.persist(lva1);
		client1.getComptes().add(lva1);
		
		// 5 OPERATION
		
		Operation op1 = new Operation();
		op1.setCompte(ct1);
		op1.setDate(new Date());
		op1.setMontant(150);
		op1.setMotif("Retrait Guichet");
		em.persist(op1);
		
		et.commit();
		em.close();
		

		
		
	}

}
