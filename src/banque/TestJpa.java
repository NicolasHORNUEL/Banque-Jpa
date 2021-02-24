package banque;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.entite.Adresse;
import banque.entite.Banque;
import banque.entite.Client;
import banque.entite.Compte;
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
		
		// 2 ADRESSE CLIENT
		Adresse a1 = new Adresse();
		a1.setCodePostale(21000);
		a1.setNumero(1);
		a1.setRue("Place de l'Étoile");
		a1.setVille("DIJON");
		
		// 3 CLIENT
		Client cl1 = new Client();
		cl1.setNom("HUBERT");
		cl1.setPrenom("Djo");
		cl1.setDateNaissance(new Date());
		cl1.setAdresse(a1);
		
		// 4 COMPTE
		Set<Client> clients = new HashSet<>();
		clients.add(cl1);
		Compte ct1 = new Compte();
		ct1.setClients(clients);
		ct1.setNumero("463786287-A");
		ct1.setOperations(null);
		ct1.setSolde(200);
		
		// 5 OPERATION
		Operation op1 = new Operation();
		op1.setCompte(ct1);
		op1.setDate(new Date());
		op1.setMontant(150);
		op1.setMotif("Retrait Guichet");
			
		em.persist(b1);	
		em.persist(cl1);	
		em.persist(ct1);
		em.persist(op1);
		
		et.commit();
		em.close();
		

		
		
	}

}
