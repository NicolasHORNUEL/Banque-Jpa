package banque.entite;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column(name="NUMERO", length = 10, nullable = true)
	private int numero;
	
	@Column(name="RUE", length = 50, nullable = true)
	private String rue;
	
	@Column(name="CODE_POSTALE", length = 10, nullable = true)
	private int codePostale;
	
	@Column(name="VILLE", length = 50, nullable = true)
	private String ville;
	
	/**
	 * Constructeur sans argument
	 */
	public Adresse() {
	}

	/**
	 * @param numero
	 * @param rue
	 * @param codePostale
	 * @param ville
	 */
	public Adresse(int numero, String rue, int codePostale, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.codePostale = codePostale;
		this.ville = ville;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
}
