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
 * Classe RechercherCircuit
 * @author ldatchi
 *
 */
public class RechercherCircuit extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe RechercherCircuit
	 */
	//Attributs privés
	//Panel
	private JPanel panelCircuit;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
  	private JLabel lblMessage;
	private JLabel lblNomCircuit;
	private JLabel lblInsertion;
  	
  	//JTextField
  	private JTextField jtfRechercher;
  	
  	//Bouton
  	private JButton btnValider;
  	
  	public RechercherCircuit() {	
	    /**
	     * Instanciation de mes panels "panelCircuit", "panelMessage", "panelChamps" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelCircuit = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelCircuit", "panelMessage", "panelChamps" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelCircuit.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(Color.white);

	    /**
	     * Mise en place des dispositions des panels "panelCircuit", "panelMessage", "panelChamps" et "panelBtnQuitter"
	     */
	    //Disposition des panels
        this.panelCircuit.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());

        /**
	     * Instanciation des label "lblMessage", "lblNomCircuit" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Rechercher des circuits.");
	    this.lblNomCircuit = new JLabel("Entrez le nom :");
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
	    this.panelCircuit.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelCircuit.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblNomCircuit);
	    this.panelChamps.add(jtfRechercher);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);

	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
  	}
  	
  	public JPanel getMonPanelCircuitRechercher() {
    	return panelCircuit;
    }
  	
  	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnValider) {
			String nomCircuit = jtfRechercher.getText();
			JLabel resultat = new JLabel("Erreur de recherche.");
			if(Modele.rechercherCircuit(nomCircuit)) {
                lblInsertion.setText("Le circuit est bien présente."); 
			}
			else {
                lblInsertion.setText("Le circuit n'est pas présente."); 
			}
		}
	}
	
}
