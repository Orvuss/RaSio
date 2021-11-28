/**
 * Classe ConstrPersonnel
 * @author ldatchi
 *
 */
public class ConstrPersonnel {

	/**
	 * Attributs privés de la classe ConstrPersonnel
	 */
	//Attributs privés
	private String nomPersonnel;
	private String prenomPersonnel;
	private String adressePersonnel;
	private String villePersonnel;
	private String cpPersonnel;
	
	/**
	 * Constructeur de la classe ConstrPersonnel
	 * @param unNomPersonnel
	 * @param unPrenomPersonnel
	 * @param uneAdressePersonnel
	 * @param uneVillePersonnel
	 * @param unCpPersonnel
	 */
	//Constructeur
	public ConstrPersonnel(String unNomPersonnel, String unPrenomPersonnel, String uneAdressePersonnel, String uneVillePersonnel,
			String unCpPersonnel) {
		this.nomPersonnel = unNomPersonnel;
		this.prenomPersonnel = unPrenomPersonnel;
		this.adressePersonnel = uneAdressePersonnel;
		this.villePersonnel = uneVillePersonnel;
		this.cpPersonnel = unCpPersonnel;
	}

	/**
	 * Accesseurs get et set
	 * @return
	 */
	public String getNomPersonnel() {
		return nomPersonnel;
	}
	public void setNomPersonnel(String unNomPersonnel) {
		this.nomPersonnel = unNomPersonnel;
	}

	public String getPrenomPersonnel() {
		return prenomPersonnel;
	}
	public void setPrenomPersonnel(String unPrenomPersonnel) {
		this.prenomPersonnel = unPrenomPersonnel;
	}

	public String getAdressePersonnel() {
		return adressePersonnel;
	}
	public void setAdressePersonnel(String uneAdressePersonnel) {
		this.adressePersonnel = uneAdressePersonnel;
	}

	public String getVillePersonnel() {
		return villePersonnel;
	}
	public void setVillePersonnel(String uneVillePersonnel) {
		this.villePersonnel = uneVillePersonnel;
	}

	public String getCpPersonnel() {
		return cpPersonnel;
	}
	public void setCpPersonnel(String unCpPersonnel) {
		this.cpPersonnel = unCpPersonnel;
	}
	
	public String toJSON() {
        String result = "";
        result += "\n\t{";
        result += "\n\t\t'nom' : " + " '" + nomPersonnel + "',";
        result += "\n\t\t'prenom' : " + " '" + prenomPersonnel + "',";
        result += "\n\t\t'adresse' : " + " '" + adressePersonnel + "',";
        result += "\n\t\t'ville' : " + " '" + villePersonnel + "',";
        result += "\n\t\t'cp' : " + " '" + cpPersonnel + "'";
        result += "\n\t},";
        return result;
    }
}
