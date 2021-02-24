package banque.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NUMERO", length = 50, nullable = true)
	private String numero;
	
	@Column(name="SOLDE", length = 50, nullable = true)
	private double solde;

	@ManyToMany
	@JoinTable(name="CLI_COM",
		joinColumns= @JoinColumn(name="ID_COM", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID")
	)
	private Set<Client> clients = new HashSet<>();
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations = new HashSet<>();
	
	/**
	 * Constructeur sans argument
	 */
	public Compte() {
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
		
}
