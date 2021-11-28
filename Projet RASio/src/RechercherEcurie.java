import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Classe RechercherEcurie
 * @author ldatchi
 *
 */
public class RechercherEcurie extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe RechercherEcurie
	 */
	//Attributs privés
	//Panel
	private JPanel panelEcurie;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
  	private JLabel lblMessage;
	private JLabel lblNomEcurie;
	private JLabel lblInsertion;
  	
  	//JTextField
  	private JTextField jtfRechercher;
  	
  	//Bouton
  	private JButton btnValider;
  	
  	public RechercherEcurie() {	
	    /**
	     * Instanciation de mes panels "panelEcurie", "panelMessage", "panelChamps" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelEcurie = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelEcurie", "panelMessage", "panelChamps" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelEcurie.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(Color.white);

	    /**
	     * Mise en place des dispositions des panels "panelEcurie", "panelMessage", "panelChamps" et "panelBtnQuitter"
	     */
	    //Disposition des panels
        this.panelEcurie.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());

        /**
	     * Instanciation des label "lblMessage", "lblNomEcurie" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Rechercher des écuries.");
	    this.lblNomEcurie = new JLabel("Entrez le nom :");
	    this.lblInsertion = new JLabel("");

	    /**
	     * Instanciation de l'entrée "jtfRechercher"
	     */
	    //Instanciation des entrées
	    this.jtfRechercher = new JTextField();
	    this.jtfRechercher.setPreferredSize(new Dimension(150, 30));
	    
	    /**
	     * Mise en place de la couleur d'écriture du label "lblMessage"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);
	    
	    /**
         * Instanciation des boutons "btnValider" et "btnRetour"
         */
	    //Instanciation des boutons
	    this.btnValider = new JButton("Valider");
	    this.btnValider.addActionListener(this);
	    
	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelEcurie.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelEcurie.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblNomEcurie);
	    this.panelChamps.add(jtfRechercher);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);

	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
  	}
  	
  	public JPanel getMonPanelEcurieRechercher() {
    	return panelEcurie;
    }
  	
  	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnValider) {
			String nomEcurie = jtfRechercher.getText();
			JLabel resultat = new JLabel("Erreur de recherche.");
			if(Modele.rechercherEcurie(nomEcurie)) {
                lblInsertion.setText("L'écurie est bien présente."); 
			}
			else {
                lblInsertion.setText("L'écurie n'est pas présente."); 
			}
		}
	}
}
