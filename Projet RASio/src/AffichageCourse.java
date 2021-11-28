import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Classe AffichageCourse
 * @author ldatchi
 *
 */
public class AffichageCourse extends JPanel implements ActionListener {
	
	/**
	 * Attributs privés de la classe AffichageCircuit
	 */
	//Attributs privés
	//Panel
    private JPanel panelCourse;
    private JPanel panelMessage;
    private JPanel panelTableau;
    
    //Label
  	private JLabel lblMessage;

  	//Tableau
    private JTable tableau;
    
    //Scrollbar
    private JScrollPane scrollPane;

    //Constructeur
    public AffichageCourse(ArrayList<ConstrCourse> listeCourse) {
    	
    	/**
	     * Instanciation de mes panels "panelCourse", "panelMessage", "panelTableau" et "panelBtnQuitter"
	     */
    	//Instanciation des panels
        this.panelCourse = new JPanel();
        this.panelTableau = new JPanel();
	    this.panelMessage = new JPanel();
        
	    /**
	     * Mise en place des background des panels "panelCourse", "panelMessage", "panelTableau" et "panelBtnQuitter"
	     */
        //Background des panels
	    this.panelCourse.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelTableau.setBackground(Color.white);

	    /**
	     * Mise en place des dispositions des panels "panelCourse", "panelMessage", "panelTableau" et "panelBtnQuitter"
	     */
        //Disposition des panels
        this.panelCourse.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());
        
	    /**
	     * Instanciation du label "lblMessage"
	     */
        //Instanciation des messages
	    this.lblMessage = new JLabel("Affichage du tableau des courses.");
	    
	    /**
	     * Mise en place de la couleur d'écriture du label "lblMessage"
	     */
	 	//Couleur de la police
	    this.lblMessage.setForeground(Color.white);
      
	    /**
	     * Création du tableau pour afficher les éléments dans le tableau
	     */
	    //Tableau
        Object data[][] = new Object[5][5];
        int i = 0;
        for (ConstrCourse maCourse: listeCourse) {
            data[i][0] = maCourse.getNomCourse();
            data[i][1] = maCourse.getTypeCourse();
            data[i][2] = maCourse.getNbSpectateur();
            data[i][3] = maCourse.getUnCircuit().getNomCircuit();
            i++;
        }
        String[] title = {
            "Nom de la course",
            "Type de Course",
            "Nombre de spectateurs",
            "Nom du circuit",
        };
        this.tableau = new JTable(data, title);
        this.tableau.setPreferredScrollableViewportSize(new Dimension(650, 300));

        /**
         * Mise en place de la taille du tableau
         */
        //Taille
        this.tableau.setRowHeight(30);

        /**
         * Mise en place de la barre de scroll
         */
        //Barre de scroll
        this.scrollPane = new JScrollPane(this.tableau);
        this.panelTableau.add(this.scrollPane);

	    /**
	     * Ajout des attributs à mes panels
	     */
        //Ajout des attributs aux panels
        this.panelCourse.add(panelMessage, BorderLayout.PAGE_START);
        
        this.panelMessage.add(lblMessage);
        
        //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
        this.panelCourse.add(this.scrollPane);
    }
    /**
     * Permet de retourner le panel course pour l'affichage
     * @return
     */
    public JPanel getMonPanelCourseAffichage() {
    	return panelCourse;
    }
    /**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
    public void actionPerformed(ActionEvent e) {
    	
    }
}
