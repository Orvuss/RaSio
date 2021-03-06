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
 * Classe SupprimerCircuit
 * @author ldatchi
 *
 */
public class SupprimerCircuit extends JPanel implements ActionListener{

	/**
	 * Attributs priv?s de la classe SupprimerCircuit
	 */
	//Attributs priv?s
	//Panel
	private JPanel panelCircuit;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
  	private JLabel lblMessage;
	private JLabel lblNomCircuit;
	private JLabel lblInsertion;
  	
  	//JTextField
  	private JTextField jtfSuppression;
  	
  	//Bouton
  	private JButton btnValider;
  	
  	public SupprimerCircuit() {
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
	    this.lblMessage = new JLabel("Suppression des circuits.");
	    this.lblNomCircuit = new JLabel("Entrez le nom :");
	    this.lblInsertion = new JLabel("");

	    /**
	     * Instanciation de l'entr?e "jtfSuppression"
	     */
	    //Instanciation des entr?es
	    this.jtfSuppression = new JTextField();
	    this.jtfSuppression.setPreferredSize(new Dimension(150, 30));
	    
	    /**
	     * Mise en place de la couleur d'?criture du label "lblMessage"
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
	     * Ajout des attributs ? mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelCircuit.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelCircuit.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblNomCircuit);
	    this.panelChamps.add(jtfSuppression);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);

	    //Toujours ? la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours ? la fin de la classe
  		 */
  		this.setVisible(true);
  	}
  	
  	public JPanel getMonPanelCircuitSupprimer() {
    	return panelCircuit;
    }
  	
  	/**
	 * Action performed permettant la navigation entre les diff?rentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		 //Si la source de l'?v?nement est le JButton appel? 
        if(e.getSource() == btnValider) {
            String nomCircuit = jtfSuppression.getText();
            JTextField result = new JTextField ("Erreur");
            if(Modele.suppressionCircuit(nomCircuit)) {
                lblInsertion.setText("Suppression effectu?e."); 
            }
            else {
                lblInsertion.setText("Suppression non effectu?e."); 
            }
        }
	}
	
}
