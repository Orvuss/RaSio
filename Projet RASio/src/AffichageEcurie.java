import java.awt. * ;
import java.awt.event.ActionEvent;
import javax.swing. * ;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Classe AffichageEcurie
 * @author leoda
 *
 */
public class AffichageEcurie extends JPanel implements ActionListener {
	
	/**
	 * Attributs privés de la classe AffichageEcurie
	 */
	//Attributs privés
	//Panel
    private JPanel panelEcurie;
    private JPanel panelMessage;
    private JPanel panelTableau;
    
    //Label
  	private JLabel lblMessage;

  	//Tableau
    private JTable tableau;
    
    //Scrollbar
    private JScrollPane scrollPane;

    //Constructeur
    public AffichageEcurie(ArrayList<ConstrEcurie> listeEcurie) {
    	
    	/**
	     * Instanciation de mes panels "panelEcurie", "panelMessage", "panelTableau" et "panelBtnQuitter"
	     */
    	//Instanciation des panels
    	this.panelEcurie = new JPanel();
        this.panelMessage = new JPanel();
        this.panelTableau = new JPanel();
        
	    /**
	     * Mise en place des background des panels "panelEcurie", "panelMessage", "panelTableau" et "panelBtnQuitter"
	     */
        //Background des panels
	    this.panelEcurie.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelTableau.setBackground(Color.white);

	    /**
	     * Mise en place des dispositions des panels "panelEcurie", "panelMessage", "panelTableau" et "panelBtnQuitter"
	     */
        //Disposition des panels
	    this.panelEcurie.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
        this.panelTableau.setLayout(new FlowLayout());
        
	    /**
	     * Instanciation du label "lblMessage"
	     */
        //Instanciation des messages
	    this.lblMessage = new JLabel("Affichage du tableau des écuries.");
	    
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
        for (ConstrEcurie monEcurie: listeEcurie) {
            data[i][0] = monEcurie.getNomEcurie();
            data[i][1] = monEcurie.getSponsorEcurie();
            data[i][2] = monEcurie.getMotoristeEcurie();            
            i++;
        }
        String[] title = {
            "Nom de l'écurie",
            "Sponsor de l'écurie",
            "Motoriste de l'écurie",
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
        this.panelEcurie.add(panelMessage, BorderLayout.PAGE_START);
        
        this.panelMessage.add(lblMessage);

        //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
        this.panelEcurie.add(this.scrollPane);
    }
    /**
     * Permet de retourner le panel ecurie pour l'affichage
     * @return
     */
    public JPanel getMonPanelEcurieAffichage() {
    	return panelEcurie;
    }
    /**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
    public void actionPerformed(ActionEvent e) {
    	
    }
}
