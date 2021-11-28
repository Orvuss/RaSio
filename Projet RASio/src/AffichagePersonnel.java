import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Classe AffichagePersonnel
 * @author ldatchi
 *
 */
public class AffichagePersonnel extends JPanel implements ActionListener {
	
	/**
	 * Attributs privés de la classe AffichagePersonnel
	 */
	//Attributs privés
	//Panel
    private JPanel panelPersonnel;
    private JPanel panelMessage;
    private JPanel panelTableau;
    
    //Label
  	private JLabel lblMessage;
  
  	//Tableau
    private JTable tableau;
    
    //Scrollbar
    private JScrollPane scrollPane;

    //Constructeur
    public AffichagePersonnel(ArrayList<ConstrPersonnel> listePersonnel) {
    	
    	/**
	     * Instanciation de mes panels "panelPersonnel", "panelMessage", "panelTableau" et "panelBtnQuitter"
	     */
    	//Instanciation des panels
    	this.panelPersonnel = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();
        
	    /**
	     * Mise en place des background des panels "panelPersonnel", "panelMessage", "panelTableau" et "panelBtnQuitter"
	     */
        //Background des panels
	    this.panelPersonnel.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelTableau.setBackground(Color.white);

	    /**
	     * Mise en place des dispositions des panels "panelPersonnel", "panelMessage", "panelTableau" et "panelBtnQuitter"
	     */
        //Disposition des panels
	    this.panelPersonnel.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());
        
	    /**
	     * Instanciation du label "lblMessage"
	     */
        //Instanciation des messages
	    this.lblMessage = new JLabel("Affichage du tableau des circuits.");
	    
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
        for (ConstrPersonnel monPersonnel: listePersonnel) {
            data[i][0] = monPersonnel.getNomPersonnel();
            data[i][1] = monPersonnel.getPrenomPersonnel();
            data[i][2] = monPersonnel.getAdressePersonnel();
            data[i][3] = monPersonnel.getVillePersonnel();  
            data[i][4] = monPersonnel.getCpPersonnel();  
            i++;
        }
        String[] title = {
            "Nom du personnel",
            "Prénom du personnel",
            "Adresse du personnel",
            "Ville du personnel",
            "CP du personnel",
        };
        this.tableau = new JTable(data, title);
        this.tableau.setPreferredScrollableViewportSize(new Dimension(350, 300));

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
        this.panelPersonnel.add(panelMessage, BorderLayout.PAGE_START);
        
        this.panelMessage.add(lblMessage);

        //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
        this.panelPersonnel.add(this.scrollPane);
    }

    /**
     * Permet de retourner le panel circuit pour l'affichage
     * @return
     */
    public JPanel getMonPanelPersonnelAffichage() {
    	return panelPersonnel;
    }
    /**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
    public void actionPerformed(ActionEvent e) {
    	
    }
}
