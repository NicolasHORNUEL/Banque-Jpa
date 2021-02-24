package banque.entite;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LivretA")
public class LivretA extends Compte {

	
	@Column(name = "TAUX", length = 10, nullable = true) // NOT NULL impossible avec SINGLE_TABLE
	private double taux;

	/**
	 * Constructeur sans argument
	 */
	public LivretA() {

	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	

}
