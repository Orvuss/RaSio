import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Classe AffichageCircuit
 * @author ldatchi
 *
 */
public class AffichageCircuit extends JPanel implements ActionListener {
	
	/**
	 * Attributs privés de la classe AffichageCircuit
	 */
	//Attributs privés
	//Panel
    private JPanel panelCircuit;
    private JPanel panelMessage;
    private JPanel panelTableau;
    
    //Label
  	private JLabel lblMessage;

  	//Tableau
    private JTable tableau;
    
    //Scrollbar
    private JScrollPane scrollPane;

    //Constructeur
    public AffichageCircuit(ArrayList<ConstrCircuit> listeCircuit) {
    	/**
	     * Instanciation de mes panels "panelCircuit", "panelMessage", "panelTableau" et "panelBtnQuitter"
	     */
    	//Instanciation des panels
    	this.panelCircuit = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();
        
	    /**
	     * Mise en place des background des panels "panelCircuit", "panelMessage", "panelTableau" et "panelBtnQuitter"
	     */
        //Background des panels
	    this.panelCircuit.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelTableau.setBackground(Color.white);

	    /**
	     * Mise en place des dispositions des panels "panelCircuit", "panelMessage", "panelTableau" et "panelBtnQuitter"
	     */
        //Disposition des panels
	    this.panelCircuit.setLayout(new BorderLayout());
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
        for (ConstrCircuit monCircuit: listeCircuit) {
            data[i][0] = monCircuit.getNomCircuit();
            data[i][1] = monCircuit.getTailleCircuit();
            data[i][2] = monCircuit.getPaysCircuit();            
            i++;
        }
        String[] title = {
            "Nom du circuit",
            "Taille du circuit",
            "Pays du circuit",
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
        this.panelCircuit.add(panelMessage, BorderLayout.PAGE_START);
        
        this.panelMessage.add(lblMessage);

        //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
        this.panelCircuit.add(this.scrollPane);
    }

    /**
     * Permet de retourner le panel circuit pour l'affichage
     * @return
     */
    public JPanel getMonPanelCircuitAffichage() {
    	return panelCircuit;
    }
    /**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
    public void actionPerformed(ActionEvent e) {
    	
    }
}
