package banque.entite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("AssuranceVie")
public class AssuranceVie extends Compte {

	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@Column(name = "TAUX", length = 10, nullable = true) // NOT NULL impossible avec SINGLE_TABLE
	private double taux;

	/**
	 * Constructeur sans argument
	 */
	public AssuranceVie() {
		super();
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
	

}