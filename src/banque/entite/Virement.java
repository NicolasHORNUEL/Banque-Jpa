package banque.entite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Virement")
public class Virement extends Operation {

	@Column(name="BENEFICIAIRE", length = 50, nullable = true) // NOT NULL impossible avec SINGLE_TABLE
	private String beneficiaire;
	
	/**
	 * Constructeur sans argument
	 */
	public Virement() {
	}

	/**
	 * @param date
	 * @param montant
	 * @param motif
	 * @param compte
	 * @param beneficiaire
	 */
	public Virement(Date date, double montant, String motif, Compte compte, String beneficiaire) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
}
