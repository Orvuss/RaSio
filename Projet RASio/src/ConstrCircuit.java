/**
 * Classe ConstrCircuit
 * @author ldatchi
 *
 */
public class ConstrCircuit {
	
	/**
	 * Attributs privés de la classe ConstrCircuit
	 */
	//Attributs privés
	private String nomCircuit;
	private String tailleCircuit;
	private String paysCircuit;
	
	/**
	 * Constructeur de la classe ConstrCircuit
	 * @param unNomCircuit
	 * @param uneTailleCircuit
	 * @param unPaysCircuit
	 */
	//Constructeur
	public ConstrCircuit(String unNomCircuit, String uneTailleCircuit, String unPaysCircuit) {
		this.nomCircuit = unNomCircuit;
		this.tailleCircuit = uneTailleCircuit;
		this.paysCircuit = unPaysCircuit;
	}

	/**
	 * Accesseurs get et set
	 * @return
	 */
	//Accesseurs
	public String getNomCircuit() {
		return nomCircuit;
	}
	public void setNomCircuit(String unNomCircuit) {
		this.nomCircuit = unNomCircuit;
	}

	public String getTailleCircuit() {
		return tailleCircuit;
	}
	public void setTailleCircuit(String uneTailleCircuit) {
		this.tailleCircuit = uneTailleCircuit;
	}

	public String getPaysCircuit() {
		return paysCircuit;
	}
	public void setPaysCircuit(String unPaysCircuit) {
		this.paysCircuit = unPaysCircuit;
	}
}
