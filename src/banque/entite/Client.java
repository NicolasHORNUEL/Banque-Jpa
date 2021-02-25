package banque.entite;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CLIENT")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOM", length = 50, nullable = true)
	private String nom;
	
	@Column(name="PRENOM", length = 50, nullable = true)
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name="BANQUE_ID")
	private Banque banque;
	
	@ManyToMany
	@JoinTable(name="CLI_COM",
		joinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_COM", referencedColumnName="ID")
	)
	private Set<Compte> comptes = new HashSet<>();
	
	/**
	 * Constructeur sans argument
	 */
	public Client() {
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adresse
	 */
	public Client(String nom, String prenom, Date dateNaissance, Adresse adresse, Banque banque) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;
	}

	@Override
	public String toString() {
		return "Client " + id + " : " + nom.toUpperCase() + " " + prenom + ", né le " + dateNaissance + ".";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}


}
