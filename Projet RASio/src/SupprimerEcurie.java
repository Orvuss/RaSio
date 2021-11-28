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
 * Classe SupprimerEcurie
 * @author ldatchi
 *
 */
public class SupprimerEcurie extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe SupprimerEcurie
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
  	private JTextField jtfSuppression;
  	
  	//Bouton
  	private JButton btnValider;
  	
  	public SupprimerEcurie() {	
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
	    this.lblMessage = new JLabel("Suppression des écuries.");
	    this.lblNomEcurie = new JLabel("Entrez le nom :");
	    this.lblInsertion = new JLabel("");

	    /**
	     * Instanciation de l'entrée "jtfSuppression"
	     */
	    //Instanciation des entrées
	    this.jtfSuppression = new JTextField();
	    this.jtfSuppression.setPreferredSize(new Dimension(150, 30));
	    
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
	    this.panelChamps.add(jtfSuppression);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);

	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
  	}
  	
  	public JPanel getMonPanelEcurieSupprimer() {
    	return panelEcurie;
    }
  	
  	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		 //Si la source de l'évènement est le JButton appelé 
        if(e.getSource() == btnValider) {
            String nomEcurie = jtfSuppression.getText();
            JTextField result = new JTextField ("Erreur");
            if(Modele.suppressionEcurie(nomEcurie)) {
                lblInsertion.setText("Suppression effectuée."); 
            }
            else {
                lblInsertion.setText("Suppression non effectuée."); 
            }
        }
	}
}
