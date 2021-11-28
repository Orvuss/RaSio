/**
 * Classe ConstrCourse
 * @author ldatchi
 *
 */
public class ConstrCourse {

	/**
	 * Attributs privés de la classe ConstrCourse
	 */
	//Attributs privés
	private String nomCourse;
	private String typeCourse;
	private int nbSpectateur;
	private ConstrCircuit unCircuit;
	
	/**
	 * Constructeur de la classe ConstrCourse
	 * @param unNomCourse
	 * @param unTypeCourse
	 * @param unNbSpectateur
	 */
	//Constructeur
	public ConstrCourse(String unNomCourse, String unTypeCourse, int unNbSpectateur, ConstrCircuit monCircuit) {
		this.nomCourse = unNomCourse;
		this.typeCourse = unTypeCourse;
		this.nbSpectateur = unNbSpectateur;
		this.unCircuit = monCircuit;
	}

	public ConstrCircuit getUnCircuit() {
		return unCircuit;
	}

	public void setUnCircuit(ConstrCircuit unCircuit) {
		this.unCircuit = unCircuit;
	}

	/**
	 * Accesseurs get et set
	 * @return
	 */
	//Accesseurs
	public String getNomCourse() {
		return nomCourse;
	}
	public void setNomCourse(String unNomCourse) {
		this.nomCourse = unNomCourse;
	}

	public String getTypeCourse() {
		return typeCourse;
	}
	public void setTypeCourse(String unTypeCourse) {
		this.typeCourse = unTypeCourse;
	}

	public int getNbSpectateur() {
		return nbSpectateur;
	}
	public void setNbSpectateur(int unNbSpectateur) {
		this.nbSpectateur = unNbSpectateur;
	}
	
	public String toXML() {
        String rep = "";
        rep += "<course>";
        rep += "\n\t<nom> " + nomCourse + " </nom>";
        rep += "\n\t<type> " + typeCourse + " </type>";
        rep += "\n\t<nbSpectateur> " + nbSpectateur + " </nbSpectateur>";
        rep += "\n</course>";
        return rep;
    }
}
