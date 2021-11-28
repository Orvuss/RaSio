/**
 * Classe ConstrEcurie
 * @author ldatchi
 *
 */
public class ConstrEcurie {
	
	/**
	 * Attributs privés de la classe ConstrEcurie
	 */
	//Attributs privés
	private String nomEcurie;
	private String sponsorEcurie;
	private String motoristeEcurie;
	
	/**
	 * Constructeur de la classe ConstrEcurie
	 * @param unNomEcurie
	 * @param unSponsorEcurie
	 * @param unMotoristeEcurie
	 */
	//Constructeur
	public ConstrEcurie(String unNomEcurie, String unSponsorEcurie, String unMotoristeEcurie) {
		this.nomEcurie = unNomEcurie;
		this.sponsorEcurie = unSponsorEcurie;
		this.motoristeEcurie = unMotoristeEcurie;
	}
	
	/**
	 * Accesseurs get et set
	 * @return
	 */
	//Accesseurs
	public String getNomEcurie() {
		return nomEcurie;
	}
	public void setNomEcurie(String unNomEcurie) {
		this.nomEcurie = unNomEcurie;
	}
	
	public String getSponsorEcurie() {
		return sponsorEcurie;
	}
	public void setSponsorEcurie(String unSponsorEcurie) {
		this.sponsorEcurie = unSponsorEcurie;
	}
	
	public String getMotoristeEcurie() {
		return motoristeEcurie;
	}
	public void setMotoristeEcurie(String unMotoristeEcurie) {
		this.motoristeEcurie = unMotoristeEcurie;
	}
	
	public String toCSV() {
        String rep = "";
        rep += nomEcurie + "," + sponsorEcurie + "," + motoristeEcurie + "\n";
        return rep;
    }
}
